package com.xhf.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.utils.LogUtils;
import com.xhf.annotation.ConfigModule;
import com.xhf.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * nacos 自定义监听
 *
 * @author zch
 */
@Component
public class NacosConfigListener {
    private Logger LOGGER = LogUtils.logger(NacosConfigListener.class);
    @Autowired
    private NacosConfigProperties configs;
    @Value("${spring.cloud.nacos.config.server-addr:}")
    private String serverAddr;
    @Value("${spring.cloud.nacos.config.namespace:}")
    private String namespace;
    @Autowired
    private ApplicationContext applicationContext;
    /**
     * 目前只考虑properties 文件
     */
    private String fileType = "properties";
    /**
     * 需要在配置文件中增加一条 MODULE_NAME 的配置,用于找到对应的 常量类
     */
    private String MODULE_NAME = "MODULE_NAME";

    @PostConstruct
    public void init() throws NacosException {
        if (StringUtils.isBlank(serverAddr)) {
            LOGGER.info("未找到 spring.cloud.nacos.config.server-addr");
            return;
        }
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr.split(":")[0]);
        if (StringUtils.isNotBlank(namespace)) {
            properties.put(PropertyKeyConst.NAMESPACE, namespace);
        }

        ConfigService configService = NacosFactory.createConfigService(properties);
        // 处理每个配置文件
        for (NacosConfigProperties.Config config : configs.getExtConfig()) {
            String dataId = config.getDataId();
            String group = config.getGroup();
            //目前只考虑properties 文件
            if (!dataId.endsWith(fileType)) continue;

            changeValue(configService.getConfig(dataId, group, 5000));

            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    changeValue(configInfo);
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        }
    }
    /**
     * 改变 常量类的 值
     *
     * @param configInfo
     */
    private void changeValue(String configInfo) {
        if (StringUtils.isBlank(configInfo)) return;
        Properties proper = new Properties();
        try {
            proper.load(new StringReader(configInfo)); //把字符串转为reader
        } catch (IOException e) {
            e.printStackTrace();
        }
        String moduleName = "";
        Enumeration enumeration = proper.propertyNames();
        //寻找MODULE_NAME的值
        while (enumeration.hasMoreElements()) {
            String strKey = (String) enumeration.nextElement();
            if (MODULE_NAME.equals(strKey)) {
                moduleName = proper.getProperty(strKey);
                break;
            }
        }
        if (StringUtils.isBlank(moduleName)) return;
        Class curClazz = null;
        // 寻找配置文件对应的常量类
        // 从spring容器中 寻找类的注解有ConfigModule 且值是 MODULE_NAME对应的
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            Class clazz = applicationContext.getBean(beanName).getClass();
            ConfigModule configModule = (ConfigModule) clazz.getAnnotation(ConfigModule.class);
            if (configModule != null && moduleName.equals(configModule.value())) {
                curClazz = clazz;
                break;
            }
        }
        if (curClazz == null) return;
        // 使用JAVA反射机制 更改常量
        enumeration = proper.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = proper.getProperty(key);
            if (MODULE_NAME.equals(key)) continue;
            try {
                Field field = curClazz.getDeclaredField(key);
                //忽略属性的访问权限
                field.setAccessible(true);
                Class<?> curFieldType = field.getType();
                field.set(null, JsonUtil.toObj(value, curFieldType));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                LOGGER.info("设置属性失败:{} {} = {} ", curClazz.toString(), key, value);
            }
        }
    }

}
