package com.sunny.other;

import com.sunny.entity.ResponseMsg;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashSet;
import java.util.Set;


@Component
@Data
public class TaskSet {

    private Set<DeferredResult<ResponseMsg<String>>> set = new HashSet<>();

}
