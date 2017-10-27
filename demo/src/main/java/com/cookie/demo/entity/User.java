package com.cookie.demo.entity;

import cn.upenny.framework.entity.BaseEntity;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "plum_user")
public class User extends BaseEntity{
    @NotEmpty(message = "username can't be null!")
    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User() {

    }

    public static List<User> parse(String json){
        if(StringUtils.isEmpty(json)){
            return null;
        }
        List<User> ret = JSON.parseArray(json, User.class);
        return ret;
    }
}
