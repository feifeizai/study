//package com.xhf.config;
//
//import com.alibaba.nacos.api.NacosFactory;
//import com.alibaba.nacos.api.PropertyKeyConst;
//import com.alibaba.nacos.api.config.ConfigService;
//import com.alibaba.nacos.api.config.listener.Listener;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.xhf.annotation.ConfGroup;
//import com.xhf.annotation.ConfValue;
//import com.xhf.utils.JsonUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.io.StringReader;
//import java.lang.reflect.Field;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.Executor;
//
///**
// * @author 谢红飞
// * date 2020-9-6
// */
//@Component
//public class ConfigCenterListener {
//
//    private static final Logger log = LoggerFactory.getLogger(ConfigCenterListener.class);
//
//    @Value("${spring.cloud.nacos.config.server-addr:}")
//    private String serverAddr;
//    @Value("${spring.cloud.nacos.config.namespace:}")
//    private String namespace;
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @PostConstruct
//    public void init() {
//        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(ConfGroup.class);
//        for (Object bean : beansWithAnnotation.values()) {
//            ConfGroup confGroup = bean.getClass().getAnnotation(ConfGroup.class);
//            if (confGroup == null) {
//                continue;
//            }
//            listener(confGroup.dataId(), confGroup.group());
//        }
//    }
//
//    private void listener(String dataId, String group) {
//        if (serverAddr == null || serverAddr.trim().length() == 0) {
//            log.info("未找到 spring.cloud.nacos.config.server-addr");
//            return;
//        }
//        Properties properties = new Properties();
//        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr.split(":")[0]);
//        if (namespace != null && namespace.trim().length() > 0) {
//            properties.put(PropertyKeyConst.NAMESPACE, namespace);
//        }
//
//        try {
//            ConfigService configService = NacosFactory.createConfigService(properties);
//            changeValue(dataId, group, configService.getConfig(dataId, group, 5000));
//            configService.addListener(dataId, group, new Listener() {
//                @Override
//                public void receiveConfigInfo(String configInfo) {
//                    changeValue(dataId, group, configInfo);
//                }
//
//                @Override
//                public Executor getExecutor() {
//                    return null;
//                }
//            });
//        } catch (NacosException e) {
//            log.error("NacosException error dataId:{}, group:{}, msg:{}", dataId, group, e.getMessage(), e);
//        }
//    }
//
//    private void changeValue(String dataId, String group, String configInfo) {
//        Properties proper = new Properties();
//        try {
//            if (configInfo != null && configInfo.trim().length() > 0) {
//                proper.load(new StringReader(configInfo));
//            }
//        } catch (IOException e) {
//            log.error("properties load error dataId:{}, group:{}, msg:{}", dataId, group, e.getMessage(), e);
//        }
//        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(ConfGroup.class);
//        for (Object bean : beansWithAnnotation.values()) {
//            ConfGroup confGroup = bean.getClass().getAnnotation(ConfGroup.class);
//            if (confGroup == null || !dataId.equals(confGroup.dataId()) || !group.equals(confGroup.group())) {
//                continue;
//            }
//            String prefix = "".equals(confGroup.prefix()) ? "" : confGroup.prefix() + ".";
//            Field[] fields = bean.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                ConfValue confValue = field.getAnnotation(ConfValue.class);
//                if (confValue == null) {
//                    continue;
//                }
//                String key = confValue.value();
//                String value = proper.getProperty(prefix + key);
//                try {
//                    if (value != null) {
//                        if (String.class.equals(field.getType())) {
//                            field.set(null, value);
//                        } else {
//                            field.set(null, JsonUtil.toObj(value, field.getType()));
//                        }
//                    } else {
//                        if (confValue.defaultValue().equals("")) {
//                            field.set(null, null);
//                        } else {
//                            if (String.class.equals(field.getType())) {
//                                field.set(null, confValue.defaultValue());
//                            } else {
//                                field.set(null, JsonUtil.toObj(confValue.defaultValue(), field.getType()));
//                            }
//                        }
//                    }
//                } catch (IllegalAccessException e) {
//                    log.error("field set error dataId:{}, group:{}, field:{}, msg:{}", dataId, group, field.getName(), e.getMessage(), e);
//                }
//            }
//        }
//    }
//
//}
