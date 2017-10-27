package com.cookie.demo.entity;

import cn.upenny.framework.entity.BaseEntity;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by shanlehong on 2017/3/21.
 */
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "plum_device_content.plum_device_sms_item")
@Data

public class SMSItem extends BaseEntity {
    public static final String DIRECTION_IN = "in";
    public static final String DIRECTION_OUT = "out";
    public static final String DIRECTION_OTHER = "other";

    private Long batchId;
    private Long userId;
    private String phone;
    private String name;
    private String direction;
    private String smsTime;
    private String content;

    public static List<SMSItem> parse(String json){
        if(StringUtils.isEmpty(json)){
            return null;
        }
        List<SMSItem> ret = JSON.parseArray(json, SMSItem.class);

        return ret;
    }

    public static void main(String[] args) {

        /*List<SMSItem> list = new ArrayList<SMSItem>();

        SMSItem smsItem = new SMSItem();
        smsItem.setContent("电话号码phone:13122868630");

        list.add(smsItem);

        System.out.println(JSON.toJSONString(list));*/

        String a = "";

        for (int i = 0; i<1; i++) {
            new Thread(new SMSItem.T(a)).start();
        }
    }


    private static class T implements Runnable{

        String s;
        public T(String s) {
            this.s = s;
        }

        public void run() {
            System.out.println("thread:" + Thread.currentThread().getName() + ":" + SMSItem.parse(s).size());
        }
    }
}
