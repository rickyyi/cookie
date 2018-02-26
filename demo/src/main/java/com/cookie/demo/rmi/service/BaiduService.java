package com.cookie.demo.rmi.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/2/24 0024.
 */
public interface BaiduService {

    @RequestMapping("http://www.baidu.com/s?ie=UTF-8&wd=")
    public Object search(String word);
}
