package entity;

import cn.upenny.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Table;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "plum_user")
public class User extends BaseEntity{
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User() {

    }
}
