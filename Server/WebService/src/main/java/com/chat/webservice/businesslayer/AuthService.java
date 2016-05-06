package com.chat.webservice.businesslayer;

import com.chat.dao.RepositoryFactory;
import com.chat.webservice.utils.TokenGeneratorI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService implements AuthServiceI {

    @Autowired
    private RepositoryFactory repositoryFactory;

    @Autowired
    private TokenGeneratorI tokenGenerator;

//    @Override
//    public UserTokenI login(String login, String pass) {
//        UserDao userDao = repositoryFactory.getUserDao();
//        User user = getAuthUser(userDao, login, pass);
//        String token = user.getToken();
//        return new UserToken(token);
//    }
//
//    @Override
//    public UserTokenI logout(String login, String pass) {
//        UserDao userDao = repositoryFactory.getUserDao();
//        UserI user = getAuthUser(userDao, login, pass);
//
//        String token = tokenGenerator.generate();
//        User updateUser = new User(user);
//        updateUser.setToken(token);
//        userDao.save(updateUser);
//        return new UserToken(token);
//    }
//
//    private UserI getAuthUser(UserDao userDao, String login, String pass) {
//        UserI user = userDao.findByLogin(login);
//        if (user == null || !pass.equals(user.getPassword())) {
//            throw new IllegalArgumentException("Login or password incorrect");
//        }
//        return user;
//    }
//
//    @Override
//    public UserTokenI authorization(String firstName, String secondName, String login, String pass) {
//        UserDao userDao = repositoryFactory.getUserDao();
//        UserI user = userDao.findByLogin(login);
//        if (user != null) {
//            throw new IllegalArgumentException("Login has already");
//        }
//        String token = tokenGenerator.generate();
//        User newUser = new User(firstName, secondName, login, pass, token);
//        repositoryFactory.getUserDao().save(newUser);
//        return new UserToken(token);
//    }
//
//    @Override
//    public boolean isValidToken(String token) {
//        UserDao userDao = repositoryFactory.getUserDao();
//        UserI user = userDao.findByToken(token);
//        return user != null;
//    }
}
