package com.xhf.log.consumer.config;

import com.xhf.log.consumer.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-29 20:46
 */
@Component
public class ConsumerHandlerInterceptor implements HandlerInterceptor {

    /**
     * traceId一般由前端的负载生成,比如Nignx
     */
    private boolean generateTraceId = true;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String ctxTraceId = null;

        // 判断Http header中是否有traceId字段,如果没有,则通过随机数生成
        if (StringUtils.isNotBlank(request.getHeader(Constants.TRACE_ID))) {
            ctxTraceId = request.getHeader(Constants.TRACE_ID);
        } else if (generateTraceId) {
            ctxTraceId = getTraceId();
        }

        MDC.put(Constants.TRACE_ID, ctxTraceId);

        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
    }

    // 通过随机数生成traceId,也可以通过其他方式实现,只要保证唯一即可
    private static String getTraceId() {
        Random random = new Random();
        String rs1 = String.valueOf(random.nextInt(10000));
        String rs2 = String.valueOf(random.nextInt(10000));
        return rs1 + rs2;
    }

}
