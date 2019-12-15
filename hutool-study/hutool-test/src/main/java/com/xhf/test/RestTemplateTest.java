package com.xhf.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhf.model.GroupVO;
import com.xhf.model.ItemVO;
import com.xhf.model.Option;
import com.xhf.utils.HttpUtil;
import com.xhf.utils.RestHttpUtil;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-13 22:11
 */
public class RestTemplateTest {

    public static String url = "http://localhost:8080/test";

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    /**
     * get请求无参数
     *
     * @throws IOException
     */
    @Test
    public void get() throws IOException {

        ResponseEntity<GroupVO<ItemVO, Option>> responseEntity = RestHttpUtil.exchange(url,
                HttpMethod.GET,
                null,
                null,
                new ParameterizedTypeReference<GroupVO<ItemVO, Option>>() {
                },
                MediaType.APPLICATION_FORM_URLENCODED);

        System.out.println(responseEntity.getBody().toString());

    }

    /**
     * get请求有参数
     */
    @Test
    public void get1() {

        String url = "http://localhost:8080/test/get";

        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "xhf");
        map.put("count", "100");
        ResponseEntity<ItemVO> responseEntity = RestHttpUtil.exchange(url, HttpMethod.GET, null, null, ItemVO.class, MediaType.APPLICATION_FORM_URLENCODED, map);

    }

    @Test
    public void post() {

        String url = "http://localhost:8080/test/form";

        LinkedMultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("id", "1");
        multiValueMap.add("name", "xhf");
        multiValueMap.add("count", "100");

        ResponseEntity<ItemVO> responseEntity = RestHttpUtil.exchange(url,
                HttpMethod.POST,
                multiValueMap,
                null,
                ItemVO.class,
                MediaType.APPLICATION_FORM_URLENCODED);
        System.out.println(responseEntity.getBody().toString());
    }

    @Test
    public void postBody() {

        String url = "http://localhost:8080/test/body";

        String json = "{\n" +
                "\"item_id\":\"1\",\n" +
                "\"name\":\"xhf\",\n" +
                "\"count\":5\n" +
                "}";
        ResponseEntity<ItemVO> responseEntity = RestHttpUtil.exchange(url,
                HttpMethod.POST,
                json,
                null,
                ItemVO.class,
                MediaType.APPLICATION_JSON_UTF8);
        System.out.println(responseEntity.getBody().toString());
    }

    @Test
    public void postBody1() {

        String url = "http://localhost:8080/test/body";

        ItemVO itemVO = new ItemVO();
        itemVO.setCount(100);
        itemVO.setId("123");
        itemVO.setName("cccc");
        ResponseEntity<ItemVO> responseEntity = RestHttpUtil.exchange(url,
                HttpMethod.POST,
                itemVO,
                null,
                ItemVO.class,
                MediaType.APPLICATION_JSON_UTF8);
        System.out.println(responseEntity.getBody().toString());
    }


    @Test
    public void delete() {


    }

}
