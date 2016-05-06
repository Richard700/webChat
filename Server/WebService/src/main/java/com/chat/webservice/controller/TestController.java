package com.chat.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String greeting(Model model) {
        return "SUCCESS";
    }

    @RequestMapping("/test-security")
    @ResponseBody
    public String testSecurity(Model model) {
        return "SUCCESS SECURITY";
    }
}
