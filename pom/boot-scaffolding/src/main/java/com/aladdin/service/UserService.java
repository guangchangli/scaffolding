package com.aladdin.service;

import com.aladdin.dao.UserMapper;
import com.aladdin.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findByUsername(User user) {
        return userMapper.findByUsername(user.getUsername());
    }

    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

}