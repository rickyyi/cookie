package com.cookie.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cookie.demo.util.EhCacheUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.alipay.api.AlipayConstants.CHARSET;

/**
 * Created by 845477519@qq.com on 2017/10/13 0013.
 */
@Controller
@RequestMapping("pay")
public class PayController {
    @RequestMapping(value = "trade")
    public void  trade(HttpServletResponse httpResponse) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipaydev.com/gateway.do",
                "2016091800538210",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCsD0aeF1f8WlfjWaRciAkTilNoeTauIj5KCfQ41IiPpxqCyjjFqtFwD5b4z3/VihxLnRcRdfp6HHU7yYSxAb6QQiOl21cU1/Z1eT+rx+prjWnRgIMVpTB1l10Bs8ahhtgoZGbOegg/9lYouCGxYZwOUmsg+hDM0Le8j1UWa8rDnqKShaAorSsUyTjvrNotQl3L9WGExaI9uZuqCP60QQo9BpZUnIoso+dZkTOgxAc7ncNjxxajkRfqKQL38b+4JHjHxSMFlzEY32tiXlLPEMVHOQRb9ALmX/kEt74gY4m27R3ANo82NOcGL8Jiy46ApdQ/CPeQN1x0XtV2oG9WRIKRAgMBAAECggEAa5CFOlInrFiidzxUV5Cn8/JXIIoe2BAKVukQJ/MeiIgUN83KXjDjDCaC4HuAVHQqKk9D26Og+nQOCll6Pdp0UuU2Ofr83sgAiQJK/s5VS/W1QMcRrBeASxNcjrLgK50MR3w1FUIPJEWRKZWrYqQ+FmoKFSygEhstspD8xa6PrWjZY7fCtfwU4fnCVJvBEjmVyWB62nQToYa10bs+jJ+m6xhV8uP2y0/9vYPGU/ZXh/vsuz0p4vSpo2W2aslo+r25bi4o2CeE40NJrOFq2aj8JELxwhX4QalbYcP6Chku/L4OuanU/iic+2hkOM8j3FkHDUW/1IRyt9n5tEcOpHJ5wQKBgQDaeKvRMcmxyGGF83naniEyHvjDerJl/9mk/qeJ37TZjkyv6NU91n+BFcWdTei+EW8FQCeVQ9cJwJaNTEVnIlzd4FSrZK//ppyr3iZDLUnqf46Lv7KFgC4whYIDcZl0ojtENTBIaP+CaE5GSiI2LybcTowuKgkvj6WPlY9ETLFOeQKBgQDJnaO1MqrlZntHjJjvdqtm9CwYzoqj5cishJJsNvOAtm3Dlc+/dcj3qpblZddPDHTbX8BW6nRwZewmM4muitQILOEmPf8C8QHA4kFyngwsuzzJuDszrw1kh3yWH5UryA1yf1r8ulDsGVUzIigc7mX10cDRW5tB0TS0gQ6M8glu2QKBgFcFxCLi+x1W3QnXTw12+XAWiC6NXCxm+lHPofq4Yjhah092piIoo8dOXdXn57J2DUwBHwNE744R6aZE4ExRkr5Kkk9nHvftbPDE32bYzl2bC7O82yZ0RXHMbFpk0KR1zre/nAjr0gMm+y7ibrg4lfkhTJNC6T/Jrz//af7hsaq5AoGBAK84dreaslWujEOxmJS9QNe4K77fejRZFt+AVDUCSPw7EAgkYioWdrNwKbZynP4RaFnjzKh9GPc6TVMiBW2RMBdu0bpHtSJcTNbSjGjNnO0fSQRTPfh8EZql+YwLJLypH667qlrsnjmjBp3q+Iu0UR6jzfzlrXg1FqYtZ3TtQW95AoGAZHsJCgSjmS9ZBoHiQCs/Y4d4kRy7TJ+yXRUSBRWA7c6Y8VW3f5LSplzyTEkHoX8pijTO6DpXvWsfvu5bdlAIr07Q8cnm4UZE9COxVWpzI6eOkJbo/U8t+Y8rGGVr3izaUK0WbkKwN4lpOg+lWX5C7TKSCMondmQwwkkLQ46kuMc=",
                "json",
                "UTF-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsm6Dn25wNOvgXEiKdlslu2Q3Aqs510U1cPyDq2aepT/4/KxDzEdk8UirEPdkMm6OEc3Fv2mvtR+Vt+nE8i09V2JPCXMs2jOzDwSAQtfG/vojDSdUa5TVYJX2fZG2nMnDBQYWuhoAcpeaonACzRkP2xrRPaZgcp82cCH3FccVaY9qtJ2OHi0iQXfDPh6OdVXpJwUYH6lznOeSOB7VdRvfZx5KcSJX3jsF+3Mya9ZK2xwBmcSJ6oWdzUE6aTaJuwwWGkzXJGgcqQ3tnLeT6Lg5gCA0Yn0+4wG/jRAf9te7uhg1zeAzsM1Ua1RpS2ElTvKzw/LXvYfAQgL7IQGFAGXQlQIDAQAB",
                "RSA2");
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://localhost:8058");
        alipayRequest.setNotifyUrl("http://localhost:8058/pay/callBack");//在公共参数中设置回跳和通知地址


        String orderNo = (new SimpleDateFormat("yyyyMMddhhmmssSSSS")).format(new Date()).toString();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("out_trade_no", orderNo);
        map.put("product_code", "FAST_INSTANT_TRADE_PAY");
        map.put("total_amount", "66.00");
        map.put("subject", "cookie的小店-cookie coffee");
        map.put("body", "cookie coffee");
        map.put("store_id", "2088102176149940");
        //map.put("passback_params", "merchantBizType%3d3C%26merchantBizNo%3d2016010101111");

        Map<String, Object> extendMap = new HashMap<String, Object>();
        extendMap.put("sys_service_provider_id", "2088511833207846");

        map.put("extend_params", extendMap);

        String s = JSONObject.toJSONString(map);

        alipayRequest.setBizContent(s);
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + AlipayConstants.CHARSET_UTF8);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "callBack")
    public void  get(HttpServletRequest httpRequest) throws Exception {
        System.out.print(IOUtils.toString(httpRequest.getInputStream()));
    }
}
