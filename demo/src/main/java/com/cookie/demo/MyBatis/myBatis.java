package com.cookie.demo.MyBatis;

import com.cookie.demo.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;

/**
 * Created by Administrator on 2018/3/7 0007.
 */
public class myBatis {
    public static void main(String[] args) throws Exception{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(sqlSessionFactoryBuilder.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int i = userDao.getAll().size();
        System.out.print(i);
    }
}
