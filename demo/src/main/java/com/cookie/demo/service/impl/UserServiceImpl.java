package com.cookie.demo.service.impl;

import cn.upenny.framework.service.impl.BaseServiceImpl;
import com.cookie.demo.dao.UserDao;
import com.cookie.demo.entity.User;
import com.cookie.demo.service.BorrowService;
import com.cookie.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    UserDao userDao;

    public String sayHello(String username) {
        System.out.print("Hello World! " + username);
        return "I am return: " + username;
    }

    public List<User> get() {
        return userDao.getAll();
    }
}
