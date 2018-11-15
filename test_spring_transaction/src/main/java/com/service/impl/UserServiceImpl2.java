package com.service.impl;

import com.domain.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceImpl2")
public class UserServiceImpl2
{
    @Autowired
    private UserMapper userMapper;

     void testTrans() throws Exception{
        this.updateUserName("22222222", 1);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateUserName(String userName, Integer userId)
    {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        userMapper.update(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addUser(String userName) throws Exception
    {
        User user = new User();
        user.setUserName(userName);
        userMapper.insert(user);

//        throw new Exception("error");
    }
}
