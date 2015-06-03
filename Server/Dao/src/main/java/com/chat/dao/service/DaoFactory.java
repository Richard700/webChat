package com.chat.dao.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vlad
 * Date: 03.06.15_13:53
 */
public class DaoFactory implements DaoFactoryI {

    @Autowired
    private AuthDaoI auth;
    @Autowired
    private FriendsDaoI friends;

    public AuthDaoI getAuth() {
        return auth;
    }

    public FriendsDaoI getFriends() {
        return friends;
    }
}
