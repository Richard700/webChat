package com.chat.dao;

import com.chat.dao.entity.User;
import com.chat.dao.entity.UserI;
import com.chat.dao.repository.UserDao;

/**
 * Created by vlad
 * Date: 04.06.15_11:43
 */
public class UserDaoMock extends JpaRepositoryMock<User, Long> implements UserDao {

    @Override
    public UserI findByLogin(String login) {
        if ("loginIsExists".equals(login)) {
            return new User("firstName", "secondName", "loginIsExists", "1234", "token");
        }
        return null;
    }

    @Override
    public UserI findByToken(String token) {
        if ("validToken".equals(token)) {
            return new User("firstName", "secondName", "loginIsExists", "1234", "token");
        }
        return null;
    }
}
