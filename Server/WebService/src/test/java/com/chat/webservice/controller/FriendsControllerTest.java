package com.chat.webservice.controller;

import com.chat.webservice.api.HttpHeader;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:controller-test-context.xml")
public class FriendsControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    //TODO count with max
    @Test
    public void testGetFriends() throws Exception {
        mockMvc.perform(
                get("/friend")
                        .header(HttpHeader.TOKEN.getHeader(), "token")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].login", is("login0")))
                .andExpect(jsonPath("$.[1].login", is("login1")))
                .andExpect(jsonPath("$.[0].firstName", is("firstName0")))
                .andExpect(jsonPath("$.[0].secondName", is("secondName0")));
    }

    @Test
    public void testAddFriend() throws Exception {
        mockMvc.perform(
                post("/friend")
                        .header(HttpHeader.TOKEN.getHeader(), "token")
                        .param("login", "loginFriend")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.login", is("loginFriend")))
                .andExpect(jsonPath("$.firstName", is("firstName")))
                .andExpect(jsonPath("$.secondName", is("secondName")));
    }

    @Test
    public void testAddFriendWithIncorrectLoginFriend() throws Exception {
        mockMvc.perform(
                post("/friend")
                        .header(HttpHeader.TOKEN.getHeader(), "token")
                        .param("login", "loginFriendIncorrect")
        )
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("User with login loginFriendIncorrect is not found")));
    }

    @Test
    public void testDeleteFriend() throws Exception {
        mockMvc.perform(
                delete("/friend")
                        .header(HttpHeader.TOKEN.getHeader(), "token")
                        .param("login", "loginFriend")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }

    @Test
    public void testDeleteFriendThatHasNotFriend() throws Exception {
        mockMvc.perform(
                delete("/friend")
                        .header(HttpHeader.TOKEN.getHeader(), "token")
                        .param("login", "loginFriendHasNotFriend")
        )
                .andExpect(status().isMethodNotAllowed())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("User with login loginFriendHasNotFriend did not friend")));
    }

    @Test
    public void testDeleteFriendWithIncorrectLoginFriend() throws Exception {
        mockMvc.perform(
                delete("/friend")
                        .header(HttpHeader.TOKEN.getHeader(), "token")
                        .param("login", "loginFriendIncorrect")
        )
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("User with login loginFriendIncorrect is not found")));
    }
}