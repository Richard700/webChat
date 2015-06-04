package com.chat.dao;

import com.chat.dao.entity.User;
import com.chat.dao.entity.UserI;
import com.chat.dao.repository.UserDaoI;

/**
 * Created by vlad
 * Date: 04.06.15_11:43
 */
public class UserDaoMock extends JpaRepositoryMock<User, Long> implements UserDaoI {

    @Override
    public UserI findByLogin(String login) {
        if ("login".equals(login)) {
            return new User("firstName", "secondName", "login", "1234", "token");
        }
        return null;
    }

    public UserI save(UserI updateUser) {
        return updateUser;
    }
}
