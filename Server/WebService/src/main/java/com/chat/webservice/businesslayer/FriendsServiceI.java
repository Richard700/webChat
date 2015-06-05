package com.chat.webservice.businesslayer;

import com.chat.webservice.api.FriendI;
import com.chat.webservice.exception.ChatServiceException;

import java.util.List;

/**
 * Created by vlad
 * Date: 05.06.15_14:33
 */
public interface FriendsServiceI {

    List<FriendI> getFriends(String token);

    FriendI addFriend(String token, String login) throws ChatServiceException;

    FriendI deleteFriend(String token, String login) throws ChatServiceException;
}
