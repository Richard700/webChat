package com.chat.webservice.auth;

import com.chat.dao.entity.UserI;
import com.chat.dao.repository.DaoFactory;
import com.chat.dao.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DaoFactory daoFactory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao userDao = daoFactory.getUserDao();
        UserI user = userDao.findByLogin(username);
        return new User(user.getLogin(),user.getPassword(), new ArrayList<>());
    }
}
