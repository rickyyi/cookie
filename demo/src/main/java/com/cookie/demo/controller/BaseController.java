package com.cookie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/21 0021.
 */
public class BaseController {

    @Autowired
    protected Validator validator;

    protected void beanValidator(Model modal, Object object, Class<?> clazz) {
        Set set = validator.validate(object, clazz);
        if (!set.isEmpty()) {

        }
    }
}
