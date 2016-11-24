package com.cookie.demo.controller;

import com.cookie.demo.service.UserService;
import com.cookie.demo.util.EhCacheUtils;
import entity.User;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 845477519@qq.com on 2016/11/24 0024.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "login")
    public @ResponseBody Object login(@RequestParam String username, @RequestParam String password) {
        User user = new User(username, password);
        User userTemp = userService.getOne(user);
        EhCacheUtils.put("userCache", username, userTemp);
        return userTemp;
    }

    @RequestMapping(value = "getUser")
    public @ResponseBody Object get(@RequestParam String username) {
        return EhCacheUtils.get("userCache", username);
    }
}
