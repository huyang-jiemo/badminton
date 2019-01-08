package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.UserStatModel;

import java.util.List;

public interface UserMapper {

    User selectByOpenid(String openid);

    List<User> selectAll();

    User selectById(Integer id);

    void insert(User user);

    void update(User user);

    void deleteById(Integer id);

    UserStatModel selectUserStat(Integer userId);
}