package com.cookie.springFramework.myBatis;

import lombok.Setter;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public class SqlProvider {

    private static ThreadLocal<Class<?>> threadLocalModelClass = new ThreadLocal();

    public static void setModelClass(Class<?> modelClass) {
        SqlProvider.threadLocalModelClass.set(modelClass);
    }

    public String getAll() {
        return "select 1";
    }
}
