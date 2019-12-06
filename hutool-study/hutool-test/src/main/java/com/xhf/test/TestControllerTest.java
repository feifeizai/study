package com.xhf.test;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhf.model.GroupVO;
import com.xhf.model.ItemVO;
import com.xhf.model.Option;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-6 22:56
 */
public class TestControllerTest {
    public static String url = "http://localhost:8080/test";

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void get() throws IOException {
        String s = HttpUtil.get(url);
        GroupVO<ItemVO, Option> vo = new GroupVO<ItemVO, Option>();
        GroupVO groupVO = mapper.readValue(s, vo.getClass());
        System.out.println(groupVO.toString());
    }

    @Test
    public void post() {


    }

    @Test
    public void delete() {


    }
}
