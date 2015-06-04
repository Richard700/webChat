package com.chat.dao.repository;

import com.chat.dao.entity.User;
import com.chat.dao.entity.UserI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad
 * Date: 03.06.15_13:57
 */
@Repository
public interface UserDaoI extends JpaRepository<User, Long> {

    UserI findByLogin(String login);

}
