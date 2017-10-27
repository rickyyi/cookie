package com.cookie.demo.websocket;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SystemWebSocketHandler implements WebSocketHandler
{

    // 创建一个集合存放websocketsession
    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();

    //连接以创建以后执行的方法
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception
    {
        users.add(session);
        String userName = (String) session.getHandshakeAttributes().get(
                Constants.WEBSOCKET_USERNAME);
        System.out.println(userName+" 链接成功... ");
        if (userName != null)
        {
            // 查询未读消息
        }
    }
    //接收客户端发送过来的方法
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage<?> message) throws Exception
    {
        String userName = (String) session.getHandshakeAttributes().get(
                Constants.WEBSOCKET_USERNAME);
        System.out.print(userName+" 用户发送了消息:");
        System.out.println(message.getPayload().toString());
        TextMessage message1=new TextMessage(userName+" say "+"您好，您的消息已经收到了");
        sendMessageToUsers(message1);
        sendMessageToUser("高国藩", message1);
    }

    //传输错误时触发
    public void handleTransportError(WebSocketSession session,
                                     Throwable exception) throws Exception
    {
        if (session.isOpen())
        {
            session.close();
        }
        users.remove(session);
    }

    //连接关闭时触发
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus closeStatus) throws Exception
    {
        users.remove(session);
    }

    public boolean supportsPartialMessages()
    {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     * @param message
     */
    public void sendMessageToUsers(TextMessage message)
    {
        for (WebSocketSession user : users)
        {
            try
            {
                if (user.isOpen())
                {
                    user.sendMessage(message);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message)
    {
        for (WebSocketSession user : users)
        {
            if (user.getHandshakeAttributes().get(Constants.WEBSOCKET_USERNAME)
                    .equals(userName))
            {
                try
                {
                    if (user.isOpen())
                    {
                        user.sendMessage(message);
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public Map<String, Object> getOnlineCount() {
        Map<String, Object> map= new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        for (WebSocketSession user : users) {
            list.add((String) user.getHandshakeAttributes().get(Constants.WEBSOCKET_USERNAME));
        }
        map.put("在线人数", users.size());
        map.put("在线用户", list);
        return map;
    }
}