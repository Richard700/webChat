package com.chat.webservice.businesslayer;

import com.chat.webservice.api.Friend;
import com.chat.webservice.api.FriendI;
import com.chat.webservice.exception.ChatServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-test-context.xml")
public class FriendsServiceTest {

    @Autowired
    private FriendsServiceI service;

    @Test
    public void testAddFriend() throws Exception {
        FriendI friendI = service.addFriend("token", "login");
        Friend expected = new Friend("login", "firstName", "secondName");
        assertEquals(expected, friendI);
    }

    @Test(expected = ChatServiceException.class)
    public void testAddFriendWithIncorrectLogin() throws Exception {
        service.addFriend("token", "incorrectLogin");
    }

    @Test(expected = ChatServiceException.class)
    public void testAddFriendWithHasFriend() throws Exception {
        service.addFriend("token", "hasFriendLogin");
    }
}