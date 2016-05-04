package com.chat.webservice.businesslayer;

import com.chat.webservice.entity.UserTokenI;

public interface AuthServiceI {

    UserTokenI login(String login, String pass);

    UserTokenI logout(String login, String pass);

    UserTokenI authorization(String firstName, String secondName, String login, String pass);

    boolean isValidToken(String token);
}
