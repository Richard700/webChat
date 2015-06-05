package com.chat.webservice.businesslayer;

import com.chat.webservice.api.FriendI;

import java.util.List;

/**
 * Created by vlad
 * Date: 05.06.15_14:33
 */
public class FriendsService implements FriendsServiceI {

    @Override
    public List<FriendI> getFriends(String token) {
        return null;
    }

    @Override
    public FriendI addFriend(String token, String login) {
        return null;
    }

    @Override
    public FriendI deleteFriend(String token, String login) {
        return null;
    }
}
