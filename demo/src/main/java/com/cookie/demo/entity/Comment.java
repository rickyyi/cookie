package com.cookie.demo.entity;

import cn.upenny.framework.entity.BaseEntity;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "comments")
public class Comment extends BaseEntity{
    private Long childrenId;
    private Long topicId;
    private Long userId;
    private String username;
    private Integer status;
    private String content;
    private String thread;

    @Transient
    private List next;
}
