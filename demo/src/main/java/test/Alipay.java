package test;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 845477519@qq.com on 2017/10/12 0012.
 */
public class Alipay {

    public static void main(String[] args) throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipaydev.com/gateway.do",
                "2016091800538210",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCsD0aeF1f8WlfjWaRciAkTilNoeTauIj5KCfQ41IiPpxqCyjjFqtFwD5b4z3/VihxLnRcRdfp6HHU7yYSxAb6QQiOl21cU1/Z1eT+rx+prjWnRgIMVpTB1l10Bs8ahhtgoZGbOegg/9lYouCGxYZwOUmsg+hDM0Le8j1UWa8rDnqKShaAorSsUyTjvrNotQl3L9WGExaI9uZuqCP60QQo9BpZUnIoso+dZkTOgxAc7ncNjxxajkRfqKQL38b+4JHjHxSMFlzEY32tiXlLPEMVHOQRb9ALmX/kEt74gY4m27R3ANo82NOcGL8Jiy46ApdQ/CPeQN1x0XtV2oG9WRIKRAgMBAAECggEAa5CFOlInrFiidzxUV5Cn8/JXIIoe2BAKVukQJ/MeiIgUN83KXjDjDCaC4HuAVHQqKk9D26Og+nQOCll6Pdp0UuU2Ofr83sgAiQJK/s5VS/W1QMcRrBeASxNcjrLgK50MR3w1FUIPJEWRKZWrYqQ+FmoKFSygEhstspD8xa6PrWjZY7fCtfwU4fnCVJvBEjmVyWB62nQToYa10bs+jJ+m6xhV8uP2y0/9vYPGU/ZXh/vsuz0p4vSpo2W2aslo+r25bi4o2CeE40NJrOFq2aj8JELxwhX4QalbYcP6Chku/L4OuanU/iic+2hkOM8j3FkHDUW/1IRyt9n5tEcOpHJ5wQKBgQDaeKvRMcmxyGGF83naniEyHvjDerJl/9mk/qeJ37TZjkyv6NU91n+BFcWdTei+EW8FQCeVQ9cJwJaNTEVnIlzd4FSrZK//ppyr3iZDLUnqf46Lv7KFgC4whYIDcZl0ojtENTBIaP+CaE5GSiI2LybcTowuKgkvj6WPlY9ETLFOeQKBgQDJnaO1MqrlZntHjJjvdqtm9CwYzoqj5cishJJsNvOAtm3Dlc+/dcj3qpblZddPDHTbX8BW6nRwZewmM4muitQILOEmPf8C8QHA4kFyngwsuzzJuDszrw1kh3yWH5UryA1yf1r8ulDsGVUzIigc7mX10cDRW5tB0TS0gQ6M8glu2QKBgFcFxCLi+x1W3QnXTw12+XAWiC6NXCxm+lHPofq4Yjhah092piIoo8dOXdXn57J2DUwBHwNE744R6aZE4ExRkr5Kkk9nHvftbPDE32bYzl2bC7O82yZ0RXHMbFpk0KR1zre/nAjr0gMm+y7ibrg4lfkhTJNC6T/Jrz//af7hsaq5AoGBAK84dreaslWujEOxmJS9QNe4K77fejRZFt+AVDUCSPw7EAgkYioWdrNwKbZynP4RaFnjzKh9GPc6TVMiBW2RMBdu0bpHtSJcTNbSjGjNnO0fSQRTPfh8EZql+YwLJLypH667qlrsnjmjBp3q+Iu0UR6jzfzlrXg1FqYtZ3TtQW95AoGAZHsJCgSjmS9ZBoHiQCs/Y4d4kRy7TJ+yXRUSBRWA7c6Y8VW3f5LSplzyTEkHoX8pijTO6DpXvWsfvu5bdlAIr07Q8cnm4UZE9COxVWpzI6eOkJbo/U8t+Y8rGGVr3izaUK0WbkKwN4lpOg+lWX5C7TKSCMondmQwwkkLQ46kuMc=",
                "json",
                "UTF-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsm6Dn25wNOvgXEiKdlslu2Q3Aqs510U1cPyDq2aepT/4/KxDzEdk8UirEPdkMm6OEc3Fv2mvtR+Vt+nE8i09V2JPCXMs2jOzDwSAQtfG/vojDSdUa5TVYJX2fZG2nMnDBQYWuhoAcpeaonACzRkP2xrRPaZgcp82cCH3FccVaY9qtJ2OHi0iQXfDPh6OdVXpJwUYH6lznOeSOB7VdRvfZx5KcSJX3jsF+3Mya9ZK2xwBmcSJ6oWdzUE6aTaJuwwWGkzXJGgcqQ3tnLeT6Lg5gCA0Yn0+4wG/jRAf9te7uhg1zeAzsM1Ua1RpS2ElTvKzw/LXvYfAQgL7IQGFAGXQlQIDAQAB",
                "RSA2");


        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        String orderNo = (new SimpleDateFormat("yyyyMMddhhmmssSSSS")).format(new Date()).toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("out_trade_no", orderNo);
        map.put("total_amount", "66.00");
        map.put("subject", "cookie的小店-cookie coffee");
        map.put("store_id", "2088102176149940");
        map.put("timeout_express", "90m");
        String s = JSONObject.toJSONString(map);
        request.setBizContent(s);
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        System.out.print(response.getBody());

        new Image(response.getQrCode());

        /*AlipayTradePayRequest request = new AlipayTradePayRequest(); //创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101002\"," +
                "    \"scene\":\"bar_code\"," +
                "    \"auth_code\":\"289646880473264671\"," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"store_id\":\"2088102176149940\"," +
                "    \"timeout_express\":\"2m\"," +
                "    \"total_amount\":\"88.88\"" +
                "  }"); //设置业务参数
        AlipayTradePayResponse response = alipayClient.execute(request); //通过alipayClient调用API，获得对应的response类
        System.out.print(response.getBody());*/
    }
}
