package com.cookie.demo.job;

import com.cookie.demo.entity.User;
import com.cookie.demo.service.UserService;
import javax.annotation.Resource;

/**
 * Created by 845477519@qq.com on 2016/11/25 0025.
 */
public class QuartzJob {

    @Resource
    UserService userService;

    public void work() {
        User user = new User("zhangsan", "123");
        System.out.println("Quartz的任务调度！！！" + userService.getOne(user).toString());
    }
}
