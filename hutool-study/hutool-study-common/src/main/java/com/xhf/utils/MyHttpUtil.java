package com.xhf.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-14 16:45
 */
public class MyHttpUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    /**
     * 发送POST请求
     *
     * @param url        请求url
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static final <T> T doPostByJson(String url, Class<T> returnType) {
        return doPostByJson(url, null, returnType);
    }

    /**
     * 发送POST请求
     *
     * @param url        请求url
     * @param data       发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static final <T, E> T doPostByJson(String url, E data, Class<T> returnType) {
        return doPost(url, data, MediaType.APPLICATION_JSON_UTF8, returnType);
    }

    /**
     * 发送POST请求
     *
     * @param url        请求url
     * @param data       发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static final <T> T doPostByFormData(String url, MultiValueMap<String, String> data, Class<T> returnType) {
        return doPost(url, data, MediaType.APPLICATION_FORM_URLENCODED, returnType);
    }


    /**
     * 发送GET请求
     *
     * @param url   请求url
     * @param clazz 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static final <T> T doGet(String url, Class<T> clazz) {
        T result = restTemplate.getForObject(url, clazz);
        return result;
    }

    /**
     * 发送GET请求
     *
     * @param url   请求url
     * @param clazz 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static final <T> T doGet(String url, Class<T> clazz, MultiValueMap<String, String> params) {
        T result = restTemplate.getForObject(url, clazz, params);
        return result;
    }

    /**
     * 发送POST请求
     *
     * @param url         请求url
     * @param data        发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param requestType 请求头类型
     * @param returnType  返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public static final <T, E> T doPost(String url, E data, MediaType requestType, Class<T> returnType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(requestType);
        HttpEntity<E> entity = new HttpEntity<>(data, headers);

        T result = restTemplate.postForObject(url, entity, returnType);

        return result;
    }
}
