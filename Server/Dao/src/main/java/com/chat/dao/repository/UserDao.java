package com.chat.dao.repository;

import com.chat.dao.entity.User;
import com.chat.dao.entity.UserI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    UserI findByLogin(String login);

    UserI findByToken(String token);

}
