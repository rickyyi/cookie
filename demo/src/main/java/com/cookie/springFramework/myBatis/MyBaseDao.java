package com.cookie.springFramework.myBatis;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public interface MyBaseDao<T> {

    @SelectProvider(type = SqlProvider.class, method = "getAll")
    @ResultMap("myMap")
    public List<T> getAll();
}
