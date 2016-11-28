package com.cookie.demo.service.impl;

import cn.upenny.framework.service.impl.BaseServiceImpl;
import com.cookie.demo.service.BorrowService;
import com.cookie.demo.service.UserService;
import entity.Borrow;
import entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    public String sayHello(String username) {
        System.out.print("Hello World! " + username);
        return "I am return: " + username;
    }
}
