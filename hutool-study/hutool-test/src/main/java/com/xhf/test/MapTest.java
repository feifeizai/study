package com.xhf.test;

import cn.hutool.core.map.MapUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-6 23:32
 */
public class MapTest {

    @Test
    public void maptest1() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_name", "xhf");
        map.put("user_age", "18");
    //  user_age->userAge
        Map<String, String> caseMap = MapUtil.toCamelCaseMap(map);
        for (String key : caseMap.keySet()) {
            System.out.println("key:" + key);
        }


    }

}
