package com.cookie.demo.rmi.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public interface TaoBaoService {

    @RequestMapping("https://s.taobao.com/search?q=")
    Object search(String word);
}
