package name.liuxi.service.impl;

import name.liuxi.domain.User;
import name.liuxi.mapper.UserMapper;
import name.liuxi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by liuxi6 on 2016/2/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper1")
    private UserMapper userMapper1;

    @Resource(name = "userMapper2")
    private UserMapper userMapper2;

    @Transactional(rollbackFor = Exception.class)
    public void addUser() throws Exception{
        User u = new User();
        u.setUserName("jta 1 " + System.currentTimeMillis());
        userMapper1.insert(u);

        User u2 = new User();
        u2.setUserName("jta 2 " + System.currentTimeMillis());
        userMapper2.insert(u2);

        throw new Exception("roll back jta");
    }
}
