package com.chat.dao;

import com.chat.dao.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactoryImpl implements RepositoryFactory {

    @Autowired
    private UserEntityRepository userRepository;
//    @Autowired
//    private FriendRepository friends;

    public UserEntityRepository getUserRepository() {
        return userRepository;
    }

//    @Override
//    public FriendRepository getFriends() {
//        return null;
//    }
}