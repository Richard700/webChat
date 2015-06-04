package com.chat.webservice.businesslayer;

import com.chat.webservice.entity.UserToken;

/**
 * Created by vlad
 * Date: 03.06.15_14:49
 */
public class AuthService implements AuthServiceI {

    @Override
    public UserToken login(String login, String pass) {
        return null;
    }

    @Override
    public UserToken logout(String login, String pass) {
        return null;
    }

    @Override
    public UserToken authorization(String firstName, String secondName, String login, String pass) {
        return null;
    }
}
