package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.User;

import java.util.List;

public interface UserMapper {

    User selectByAccount(String account);

    User selectByOpenid(String openid);

    List<User> selectAll();

    User selectById(Integer id);

    void insert(User user);

    void update(User user);

    void deleteById(Integer id);
}