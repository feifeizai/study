package com.xhf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-6 22:19
 */
@Data
public class ItemVO {

    @JsonProperty(value = "item_id")
    private String id;

    private String name;

    private Integer count;

}
