package com.service.impl;

import com.domain.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by liuxi6 on 2015/12/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 为了测试方法可见性，UserServiceImpl2没有实现接口
     */
    @Resource(name = "userServiceImpl2")
    private UserServiceImpl2 userServiceImpl2;

    //     @Transactional(rollbackFor = Exception.class)
    public void updateTestTrans() throws Exception{
        String userName = "name_" + System.currentTimeMillis();
        System.out.println(String.format("userName = %s", userName));

//        this.updateUserName(userName, 1);
//        userServiceImpl2.testTrans();
        try {//测试动态数据源的异常回滚
            userServiceImpl2.addUser(userName);
        }catch (Exception e){
            System.out.println("error-->" + e.getMessage());
        }

        userServiceImpl2.updateUserName(userName, 1);
//        this.addUser(userName);

//        User user = new User();
//        user.setUserId(2);
//        user.setUserName(userName);
//        userMapper.update(user);

        //测试方法可见性
//        userServiceImpl2.addUser(userName);

//        throw new Exception("error");
    }

    public void updateUserName(String userName, Integer userId)
    {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        userMapper.update(user);
    }

    private void addUser(String userName) throws Exception
    {
        User user = new User();
        user.setUserName(userName);
        userMapper.insert(user);
    }
}
