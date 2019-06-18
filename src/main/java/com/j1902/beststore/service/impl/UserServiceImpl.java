package com.j1902.beststore.service.impl;

import com.j1902.beststore.mapper.UserMapper;
import com.j1902.beststore.pojo.User;
import com.j1902.beststore.pojo.UserExample;
import com.j1902.beststore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andEmailEqualTo(user.getEmail());
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.size() == 0) {
            return false;
        }
        return users.get(0).getPassword().equals(user.getPassword());
    }
}
