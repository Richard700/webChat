package com.chat.webservice.controller;

import com.chat.webservice.businesslayer.AuthServiceI;
import com.chat.webservice.entity.UserTokenI;
import com.chat.webservice.exception.ServiceHttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthServiceI service;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserTokenI login(@RequestParam("login") String login,
                            @RequestParam("pass") String pass) throws Exception {
        checkIsEmpty(login, "Login");
        checkIsEmpty(pass, "Password");
        try {
            return service.login(login, pass);
        } catch (Exception e) {
            throw new ServiceHttpException(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserTokenI logout(@RequestParam("login") String login,
                             @RequestParam("pass") String pass) throws Exception {
        checkIsEmpty(login, "Login");
        checkIsEmpty(pass, "Password");
        try {
            return service.logout(login, pass);
        } catch (Exception e) {
            throw new ServiceHttpException(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserTokenI authorization(@RequestParam("firstName") String firstName,
                                    @RequestParam("secondName") String secondName,
                                    @RequestParam("login") String login,
                                    @RequestParam("pass") String pass) throws Exception {
        checkIsEmpty(firstName, "First name");
        checkIsEmpty(secondName, "Second name");
        checkIsEmptyOrHasSpace(login, "Login");
        checkIsEmptyOrHasSpace(pass, "Password");
        try {
            return service.authorization(firstName, secondName, login, pass);
        } catch (Exception e) {
            throw new ServiceHttpException(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    private void checkIsEmpty(String str, String name) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(name + " is empty");
        }
    }

    private void checkIsEmptyOrHasSpace(String str, String name) {
        checkIsEmpty(str, name);
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(str);
        boolean space = matcher.find();
        if (space) {
            throw new IllegalArgumentException(name + " has spaces");
        }
    }
}