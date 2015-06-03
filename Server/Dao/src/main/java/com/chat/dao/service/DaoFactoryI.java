package com.chat.dao.service;

/**
 * Created by vlad
 * Date: 03.06.15_13:55
 */
public interface DaoFactoryI {

    public AuthDaoI getAuth();

    public FriendsDaoI getFriends();

}
