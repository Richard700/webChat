package com.chat.webservice.businesslayer;

import com.chat.webservice.api.Friend;
import com.chat.webservice.api.FriendI;
import com.chat.webservice.exception.ChatServiceException;
import com.chat.webservice.exception.TypeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad
 * Date: 05.06.15_14:35
 */
public class FriendsServiceMock implements FriendsServiceI {

    @Override
    public List<FriendI> getFriends(String token) {
        List<FriendI> friends = new ArrayList<>();
        if ("token".equals(token)) {
            friends.add(new Friend("login0", "firstName0", "secondName0"));
            friends.add(new Friend("login1", "firstName1", "secondName1"));
        }
        return friends;
    }

    @Override
    public FriendI addFriend(String token, String login) throws ChatServiceException {
        if ("token".equals(token) && "loginFriend".equals(login)) {
            return new Friend(login, "firstName", "secondName");
        }
        throw new ChatServiceException("User with login " + login + " is not found", TypeException.INCORRECT_LOGIN);
    }

    @Override
    public FriendI deleteFriend(String token, String login) throws ChatServiceException {
        if ("token".equals(token) && "loginFriend".equals(login)) {
            return new Friend(login, "firstName", "secondName");
        }
        if ("token".equals(token) && "loginFriendHasNotFriend".equals(login)) {
            throw new ChatServiceException("User with login " + login + " did not friend", TypeException.EXECUTE_IMPOSSIBLE);
        }
        throw new ChatServiceException("User with login " + login + " is not found", TypeException.INCORRECT_LOGIN);
    }
}
