package com.chat.webservice.controller;

import com.chat.webservice.businesslayer.AuthServiceI;
import com.chat.webservice.entity.UserToken;
import com.chat.webservice.entity.UserTokenI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by vlad
 * Date: 03.06.15_14:45
 */

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthServiceI service;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserToken login(@RequestParam("login") String login,
                           @RequestParam("pass") String pass) {
        return new UserToken("hello");
    }
}
