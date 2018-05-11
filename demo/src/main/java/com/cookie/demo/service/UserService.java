package com.cookie.demo.service;

import cn.upenny.framework.service.BaseService;
import com.cookie.demo.entity.User;

import java.util.List;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
public interface UserService extends BaseService<User> {
    public String sayHello(String username);

    public List get();

    public List<String> getDemoAll();
}
