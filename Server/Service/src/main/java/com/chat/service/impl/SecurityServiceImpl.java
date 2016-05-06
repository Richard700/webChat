package com.chat.service.impl;

import com.chat.dao.entity.UserEntity;
import com.chat.dao.RepositoryFactory;
import com.chat.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private RepositoryFactory repositoryFactory;

    @Override
    public User getUser(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repositoryFactory.getUserRepository().findByLogin(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(userEntity.getLogin(), userEntity.getPassword(), new ArrayList<>());
    }
}
