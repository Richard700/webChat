package com.chat.dao;

import com.chat.dao.repository.UserEntityRepository;

public interface RepositoryFactory {

    UserEntityRepository getUserRepository();

//    public FriendRepository getFriends();

}
