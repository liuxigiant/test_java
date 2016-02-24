package com.service.impl;

import com.domain.User;
import com.mapper.UserMapper;
import com.service.TestLTWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liuxi6 on 2016/2/23.
 */
@Service
public class TestLTWServiceImpl implements TestLTWService {

    @Autowired
    private UserMapper userMapper;

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(String name) throws Exception{
        Integer rows = testInternalInvokeAop(name);
        if (null == rows || rows != 1){
            return false;
        } else {
            return true;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    private Integer testInternalInvokeAop(String name) throws Exception{
        User user = new User();
        user.setUserName(name);
        Integer rows = userMapper.insert(user);
        if (true) {
            throw new Exception("exception for rollBack");
        }
        return rows;
    }
}
