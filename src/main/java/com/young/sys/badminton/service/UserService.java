package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.UserMapper;
import com.young.sys.badminton.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  用户service服务类
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    public User selectByOpenid(String openid){
        return userMapper.selectByOpenid(openid);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
