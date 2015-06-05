package com.chat.webservice.businesslayer;

import com.chat.webservice.entity.UserTokenI;

/**
 * Created by vlad
 * Date: 03.06.15_14:49
 */
public interface AuthServiceI {

    UserTokenI login(String login, String pass);

    UserTokenI logout(String login, String pass);

    UserTokenI authorization(String firstName, String secondName, String login, String pass);

    boolean isValidToken(String token);
}
