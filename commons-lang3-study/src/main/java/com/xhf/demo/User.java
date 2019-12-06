package com.xhf.demo;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-11-30 16:44
 */
public class User {
    private String name;

    private Integer age;

    public boolean isSleep;

    public String sayMethod(String s){
        return name+"人说:"+s;
    }

    private Integer ageMethod(){
        return age;
    }

    private boolean sleepMethod(){
        return isSleep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        isSleep = sleep;
    }
}
