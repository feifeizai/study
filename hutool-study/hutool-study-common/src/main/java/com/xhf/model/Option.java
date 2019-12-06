package com.xhf.model;

import lombok.Data;

import java.util.List;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-6 22:20
 */
@Data
public class Option {

    List<Catogory> category;

    @Data
    public static class Catogory{

        private String categoryId;

        private String name;
    }
}
