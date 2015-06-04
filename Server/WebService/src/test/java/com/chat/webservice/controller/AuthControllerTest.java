package com.chat.webservice.controller;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:service-test-context.xml")
public class AuthControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(
                get("/auth/login")
                        .param("login", "login")
                        .param("pass", "1234")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.token", is("token")));
    }

    @Test
    public void testLoginIncorrectLoginOrPass() throws Exception {
        mockMvc.perform(
                get("/auth/login")
                        .param("login", "login")
                        .param("pass", "bad")
        )
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Login or password incorrect")));
    }

    @Test
    public void testLogout() throws Exception {
        mockMvc.perform(
                get("/auth/logout")
                        .param("login", "login")
                        .param("pass", "1234")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.token", is("token")));
    }

    @Test
    public void testLogoutIncorrectPass() throws Exception {
        mockMvc.perform(
                get("/auth/logout")
                        .param("login", "richard")
                        .param("pass", "bad")
        )
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Login or password incorrect")));
    }

    @Test
    public void testAuthorization() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "firstName")
                        .param("secondName", "secondName")
                        .param("login", "login")
                        .param("pass", "1234")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.token", is("token")));
    }

    @Test
    public void testAuthorizationFirstNameIsEmpty() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "")
                        .param("secondName", "secondName")
                        .param("login", "login")
                        .param("pass", "1234")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("First name is empty")));
    }

    @Test
    public void testAuthorizationSecondNameIsEmpty() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "firstName")
                        .param("secondName", "")
                        .param("login", "login")
                        .param("pass", "1234")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Second name is empty")));
    }

    @Test
    public void testAuthorizationLoginIsEmpty() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "firstName")
                        .param("secondName", "secondName")
                        .param("login", "")
                        .param("pass", "1234")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Login is empty")));
    }

    @Test
    public void testAuthorizationLoginIsExists() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "firstName")
                        .param("secondName", "secondName")
                        .param("login", "loginIsExists")
                        .param("pass", "1234")
        )
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Login has already")));
    }

    @Test
    public void testAuthorizationLoginIsHasSpace() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "firstName")
                        .param("secondName", "secondName")
                        .param("login", "login has space")
                        .param("pass", "1234")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Login has spaces")));
    }

    @Test
    public void testAuthorizationPassIsEmpty() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "firstName")
                        .param("secondName", "secondName")
                        .param("login", "loginIsExists")
                        .param("pass", "")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Password is empty")));
    }

    @Test
    public void testAuthorizationPassIsHasSpace() throws Exception {
        mockMvc.perform(
                get("/auth/add")
                        .param("firstName", "firstName")
                        .param("secondName", "secondName")
                        .param("login", "login")
                        .param("pass", "pass has spaces")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Password has spaces")));
    }
}