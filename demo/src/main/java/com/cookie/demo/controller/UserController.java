package com.cookie.demo.controller;

import com.cookie.demo.entity.Comment;
import com.cookie.demo.entity.User;
import com.cookie.demo.service.CommentService;
import com.cookie.demo.service.UserService;
import com.cookie.demo.util.EhCacheUtils;
import com.cookie.demo.websocket.Constants;
import com.cookie.demo.websocket.SystemWebSocketHandler;
import com.google.gson.Gson;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 845477519@qq.com on 2016/11/24 0024.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @Resource
    UserService userService;

    @Resource
    com.cookie.demo.rmi.UserService rmiUserService;

    @Resource
    SystemWebSocketHandler systemWebSocketHandler;

    @Resource
    CommentService commentService;

    static int count = 0;

    @RequestMapping(value = "login")
    public @ResponseBody Object login(User user, BindingResult result, Model model, HttpServletRequest httpServletRequest) {
        /*super.beanValidator(model, user, user.getClass());
        if (result.hasErrors()) {
            return result.getFieldErrors().get(0).getDefaultMessage().toString();
        }*/
        HttpSession httpSession= httpServletRequest.getSession();
        httpSession.setAttribute(Constants.SESSION_USERNAME, user.getUsername());
        User userTemp = userService.getOne(user);
        EhCacheUtils.put("userCache", user.getUsername(), userTemp);
        return userTemp;
    }

    @RequestMapping(value = "getUser")
    public @ResponseBody Object get(@RequestParam String username) {
        return EhCacheUtils.get("userCache", username);
    }

    @RequestMapping(value = "getComment")
    public @ResponseBody Object getComment(@RequestParam Long topicId) {
        Comment comment = new Comment();
        comment.setTopicId(topicId);
        //comment.setParentId(0L);
        List<Comment> commentList;
        /*for (Comment ctp : commentList) {
            Comment c1 = new Comment();
            c1.setParentId(ctp.getId());
            ctp.setNext(commentService.getByObj(comment));
        }*/

        while (true) {
            commentList = commentService.getByObj(comment);
            for (Comment ctp : commentList) {
                if (ctp.getChildrenId() != 0) {
                    Comment c1 = new Comment();
                    c1.setId(ctp.getChildrenId());
                }
            }
        }

    }


    @RequestMapping(value = "/pushNotify/{name}", method ={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String testWebSocket(@PathVariable String name) throws IOException {
        systemWebSocketHandler.sendMessageToUser(name, new TextMessage("系统推送通知"));
        return "1";
    }

    @RequestMapping(value = "/getOnlineCount", method =RequestMethod.GET)
    @ResponseBody
    public Map getOnlineCount() throws Exception {
        return systemWebSocketHandler.getOnlineCount();
    }

    @RequestMapping(value = "get", method =RequestMethod.GET)
    @ResponseBody
    public Object get(long id) throws IOException {
        //return rmiUserService.getUser(id);
        return userService.getDemoAll();
    }

}
