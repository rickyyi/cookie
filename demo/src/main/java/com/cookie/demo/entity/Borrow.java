package com.cookie.demo.entity;

import cn.upenny.approve.common.enums.LoanType;
import cn.upenny.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by 845477519@qq.com on 2016/11/22 0022.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "plum_borrow")
public class Borrow extends BaseEntity {
    private Long userId;
    private String nid;
    private Long productId;
    private BigDecimal amount;
    private Integer status;
    private Long statusUpdateTime;
    private LoanType loanType;
    private String merchantId;
    private String merchantBillNo;
    private Long interestId;
}
