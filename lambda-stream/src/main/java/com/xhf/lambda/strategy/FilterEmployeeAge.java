package com.xhf.lambda.strategy;

import com.xhf.lambda.Employee;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-10-11 22:53
 */
public class FilterEmployeeAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() <= 35;
    }
}
