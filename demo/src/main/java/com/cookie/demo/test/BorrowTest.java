package com.cookie.demo.test;

import com.cookie.demo.service.BorrowService;
import com.cookie.demo.service.UserService;
import entity.Borrow;
import entity.User;
import org.apache.cxf.common.i18n.Exception;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BorrowTest {

    @Resource
    BorrowService borrowService;

    @Transactional(rollbackFor = NullPointerException.class, readOnly = false)
    public static void main(String[] args) throws java.lang.Exception{
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:/applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userServiceImpl");
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        int i = userService.insert(user);
        //Thread.sleep(10000l);
        System.out.print(i);
        throw new NullPointerException();
    }
}
