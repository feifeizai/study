package com.xhf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-6 22:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupVO<T,R> {

    List<T> list;

    R options;

}
