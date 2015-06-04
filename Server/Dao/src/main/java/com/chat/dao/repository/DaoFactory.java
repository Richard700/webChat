package com.chat.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vlad
 * Date: 03.06.15_13:53
 */

public class DaoFactory implements DaoFactoryI {

    @Autowired
    private UserDaoI auth;
//    @Autowired
//    private FriendsDaoI friends;

    public UserDaoI getUserDao() {
        return auth;
    }

//    @Override
//    public FriendsDaoI getFriends() {
//        return null;
//    }


    public void setAuth(UserDaoI auth) {
        this.auth = auth;
    }
}
