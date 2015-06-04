package com.chat.webservice.businesslayer;

import com.chat.webservice.entity.UserTokenI;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-test-context.xml")
public class AuthServiceTest {

    @Autowired
    private AuthServiceI service;

    @Test
    public void testAuthorization() throws Exception {
        UserTokenI userToken = service.authorization("firstName", "secondName", "login", "1234");
        Assert.assertEquals("token", userToken.getToken());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAuthorizationLoginIsExists() throws Exception {
        service.authorization("firstName", "secondName", "loginIsExists", "1234");
    }

    @Test
    public void testLogin() throws Exception {
        UserTokenI userToken = service.login("login", "1234");
        Assert.assertEquals("token", userToken.getToken());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoginIncorrectLogin() throws Exception {
        service.login("incorrect", "1234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoginIncorrectPass() throws Exception {
        service.login("login", "incorrect");
    }

    @Test
    public void testLogout() throws Exception {
        UserTokenI userToken = service.logout("login", "1234");
        Assert.assertEquals("token", userToken.getToken());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLogoutIncorrectLogin() throws Exception {
        service.logout("incorrect", "pass");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLogoutIncorrectPass() throws Exception {
        service.logout("login", "incorrect");
    }

}