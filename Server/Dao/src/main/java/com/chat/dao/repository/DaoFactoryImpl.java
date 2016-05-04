package com.chat.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoFactoryImpl implements DaoFactory {

    @Autowired
    private UserDao auth;
//    @Autowired
//    private FriendsDao friends;

    public UserDao getUserDao() {
        return auth;
    }

//    @Override
//    public FriendsDao getFriends() {
//        return null;
//    }


    public void setAuth(UserDao auth) {
        this.auth = auth;
    }
}
