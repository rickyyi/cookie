package com.cookie.demo.rmi;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

/**
 * Created by 845477519@qq.com on 2017/10/27 0027.
 */
@Service
public class BeanDefinitionParser implements org.springframework.beans.factory.xml.BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return null;
    }
}
