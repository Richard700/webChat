package com.chat.webservice.controller;

import com.chat.webservice.api.FriendI;
import com.chat.webservice.api.HttpHeader;
import com.chat.webservice.businesslayer.FriendsServiceI;
import com.chat.webservice.exception.ServiceHttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vlad
 * Date: 05.06.15_13:36
 */
@Controller
@RequestMapping(value = "/friend")
public class FriendsController {

    @Autowired
    private FriendsServiceI service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FriendI> getFriends(@RequestHeader("X-Auth-Token") String token) throws Exception {
        return service.getFriends(token);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FriendI addFriend(@RequestHeader("X-Auth-Token") String token,
                             @RequestParam("login") String login) throws Exception {
        return service.addFriend(token, login);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FriendI deleteFriend(@RequestHeader("X-Auth-Token") String token,
                                @RequestParam("login") String login) throws Exception {
        return service.deleteFriend(token, login);
    }
}