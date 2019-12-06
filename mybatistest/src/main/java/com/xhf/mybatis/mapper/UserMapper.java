package com.xhf.mybatis.mapper;

import com.xhf.mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-4-22 21:35
 */
@Repository
public interface UserMapper {


    public User findUserById(Integer userId);

    public User findUser(Integer userId);

    public Integer findRoleId(Integer userId);

    public Map<String,Object> findUserMap(Integer userId);
}
