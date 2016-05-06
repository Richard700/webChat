package com.chat.webservice.businesslayer;

import com.chat.webservice.entity.UserToken;
import com.chat.webservice.entity.UserTokenI;

/**
 * Created by vlad
 * Date: 04.06.15_10:14
 */
public class AuthServiceMock implements AuthServiceI {

//    @Override
//    public UserTokenI login(String login, String pass) {
//        if ("login".equals(login) && "1234".equals(pass)) {
//            return new UserToken("token");
//        }
//        throw new IllegalArgumentException("Login or password incorrect");
//    }
//
//    @Override
//    public UserTokenI logout(String login, String pass) {
//        if ("login".equals(login) && "1234".equals(pass)) {
//            return new UserToken("token");
//        }
//        throw new IllegalArgumentException("Login or password incorrect");
//    }
//
//    @Override
//    public UserTokenI authorization(String firstName, String secondName, String login, String pass) {
//        if ("loginIsExists".equals(login)) {
//            throw new IllegalArgumentException("Login has already");
//        }
//        if ("firstName".equals(firstName) && "secondName".equals(secondName) && "login".equals(login) && "1234".equals(pass)) {
//            return new UserToken("token");
//        }
//        throw new IllegalArgumentException("Login or password incorrect");
//    }
//
//    @Override
//    public boolean isValidToken(String token) {
//        if ("validToken".equals(token)) {
//            return true;
//        }
//        return false;
//    }
}
