package com.cookie.demo.rmi;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public interface UserService {

    @RequestMapping("api/userService")
    Object getUser(Long userId);
}
