package com.chat.webservice.businesslayer;

import com.chat.dao.entity.User;
import com.chat.dao.entity.UserI;
import com.chat.dao.repository.DaoFactory;
import com.chat.dao.repository.UserDao;
import com.chat.webservice.entity.UserToken;
import com.chat.webservice.entity.UserTokenI;
import com.chat.webservice.utils.TokenGeneratorI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService implements AuthServiceI {

    @Autowired
    private DaoFactory daoFactory;

    @Autowired
    private TokenGeneratorI tokenGenerator;

    @Override
    public UserTokenI login(String login, String pass) {
        UserDao userDao = daoFactory.getUserDao();
        UserI user = getAuthUser(userDao, login, pass);
        String token = user.getToken();
        return new UserToken(token);
    }

    @Override
    public UserTokenI logout(String login, String pass) {
        UserDao userDao = daoFactory.getUserDao();
        UserI user = getAuthUser(userDao, login, pass);

        String token = tokenGenerator.generate();
        User updateUser = new User(user);
        updateUser.setToken(token);
        userDao.save(updateUser);
        return new UserToken(token);
    }

    private UserI getAuthUser(UserDao userDao, String login, String pass) {
        UserI user = userDao.findByLogin(login);
        if (user == null || !pass.equals(user.getPassword())) {
            throw new IllegalArgumentException("Login or password incorrect");
        }
        return user;
    }

    @Override
    public UserTokenI authorization(String firstName, String secondName, String login, String pass) {
        UserDao userDao = daoFactory.getUserDao();
        UserI user = userDao.findByLogin(login);
        if (user != null) {
            throw new IllegalArgumentException("Login has already");
        }
        String token = tokenGenerator.generate();
        User newUser = new User(firstName, secondName, login, pass, token);
        daoFactory.getUserDao().save(newUser);
        return new UserToken(token);
    }

    @Override
    public boolean isValidToken(String token) {
        UserDao userDao = daoFactory.getUserDao();
        UserI user = userDao.findByToken(token);
        return user != null;
    }
}
