package com.xhf.config;

import com.xhf.annotation.ConfGroup;
import com.xhf.annotation.ConfValue;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.*;

/**
 * @author 谢红飞
 * date 2020-9-6
 */
@RefreshScope
@ConfGroup(dataId = "example", prefix = "nacos")
public class NacosConstants {

    @ConfValue(value = "test", defaultValue = "xhf")
    public static volatile String TEST;

    @ConfValue(value = "list.string", defaultValue = "[\"x\",\"h\"]")
    public static volatile List<String> TEST_LIST;


    @ConfValue(value = "map", defaultValue = "{}")
    public static volatile Map<String,Object> TEST_MAP = new HashMap<>();


    @ConfValue(value = "list.integer", defaultValue = "[]")
    public static volatile List<Integer> TEST_LIST_INT = new ArrayList<>();

    @ConfValue(value = "Long", defaultValue = "100")
    public static volatile Long TEST_LONG;

    @ConfValue(value = "int", defaultValue = "0")
    public static volatile int TEST_INT ;
}
