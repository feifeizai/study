package com.xhf.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@JobHandler(value = "userHandler")
public class UserHandler extends IJobHandler {

    public ReturnT<String> execute(String param) {

        log.info("=== 调用了UserHandler ===");

        return ReturnT.SUCCESS;
    }
}
