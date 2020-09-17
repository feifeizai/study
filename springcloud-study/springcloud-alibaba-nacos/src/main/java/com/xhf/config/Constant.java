package com.xhf.config;

import com.xhf.annotation.ConfigModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 谢红飞
 * date 2020-9-6
 */
@ConfigModule("sm")
public class Constant {

    public static volatile String TEST = new String("test");

    public static volatile List<String> TEST_LIST = new ArrayList<>();
    static {
        TEST_LIST.add("默认值");
    }

    public static volatile Map<String,Object> TEST_MAP = new HashMap<>();
    static {
        TEST_MAP.put("KEY","初始化默认值");
    }

    public static volatile List<Integer> TEST_LIST_INT = new ArrayList<>();
    static {
        TEST_LIST_INT.add(1);
    }

    public static volatile Long TEST_LONG = 100L;

    public static volatile int TEST_INT = 0;
}
