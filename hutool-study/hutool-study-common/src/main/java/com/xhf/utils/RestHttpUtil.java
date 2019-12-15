package com.xhf.utils;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-14 17:10
 */
public class RestHttpUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    /**
     *
     * @param url http://api.taobao.com
     * @param method 请求方式
     * @param params 需要放到请求体的参数, 可以是json字符串, bean, k-v
     * @param headers 请求头
     * @param responseType 返回值类型
     * @param mediaType
     * @param uriVariables 需要拼接到url上的参数, ->http://api.taobao.com?name=xxx&site=1
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> exchange(String url,
                                                 HttpMethod method,
                                                 @Nullable Object params,
                                                 @Nullable MultiValueMap<String, String> headers,
                                                 Class<T> responseType,
                                                 MediaType mediaType,
                                                 @Nullable Map<String, String> uriVariables) {

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        if (uriVariables != null) {
            multiValueMap.setAll(uriVariables);
        }

        String requestPath = UriComponentsBuilder.fromHttpUrl(url).queryParams(multiValueMap).build().toUriString();
        // header
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            httpHeaders.addAll(headers);
        }
        // 提交方式：表单、json
        httpHeaders.setContentType(mediaType);
        HttpEntity<Object> httpEntity = new HttpEntity(params, httpHeaders);

        ResponseEntity<T> responseEntity = restTemplate.exchange(requestPath, method, httpEntity, responseType);

        return responseEntity;
    }

    public static <T> ResponseEntity<T> exchange(String url,
                                                 HttpMethod method,
                                                 @Nullable Object params,
                                                 @Nullable MultiValueMap<String, String> headers,
                                                 ParameterizedTypeReference<T> responseType,
                                                 MediaType mediaType,
                                                 @Nullable Map<String, String> uriVariables) {

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        if (uriVariables != null) {
            multiValueMap.setAll(uriVariables);
        }

        String requestPath = UriComponentsBuilder.fromHttpUrl(url).queryParams(multiValueMap).build().toUriString();
        // header
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            httpHeaders.addAll(headers);
        }
        // 提交方式：表单、json
        httpHeaders.setContentType(mediaType);
        HttpEntity<Object> httpEntity = new HttpEntity(params, httpHeaders);

        ResponseEntity<T> responseEntity = restTemplate.exchange(requestPath, method, httpEntity, responseType);

        return responseEntity;
    }

    /**
     * 这种不需要再url中拼接参数, 所有的请求参数都放到请求体
     * @param url
     * @param method
     * @param params
     * @param headers
     * @param responseType
     * @param mediaType
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> exchange(String url,
                                                 HttpMethod method,
                                                 @Nullable Object params,
                                                 @Nullable MultiValueMap<String, String> headers,
                                                 Class<T> responseType,
                                                 MediaType mediaType) {
        // header
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            httpHeaders.addAll(headers);
        }
        // 提交方式：表单、json
        httpHeaders.setContentType(mediaType);
        HttpEntity<Object> httpEntity = new HttpEntity(params, httpHeaders);

        ResponseEntity<T> responseEntity = restTemplate.exchange(url, method, httpEntity, responseType);

        return responseEntity;
    }

    /**
     * 这种不需要再url中拼接参数, 所有的请求参数都放到请求体
     * @param url
     * @param method
     * @param params
     * @param headers
     * @param responseType
     * @param mediaType
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> exchange(String url,
                                                 HttpMethod method,
                                                 @Nullable Object params,
                                                 @Nullable MultiValueMap<String, String> headers,
                                                 ParameterizedTypeReference<T> responseType,
                                                 MediaType mediaType) {
        // header
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            httpHeaders.addAll(headers);
        }
        // 提交方式：表单、json
        httpHeaders.setContentType(mediaType);
        HttpEntity<Object> httpEntity = new HttpEntity(params, httpHeaders);

        ResponseEntity<T> responseEntity = restTemplate.exchange(url, method, httpEntity, responseType);

        return responseEntity;
    }

}
