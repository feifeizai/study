package com.xhf.lambda.strategy;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-10-11 22:52
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
