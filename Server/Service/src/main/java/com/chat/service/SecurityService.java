package com.chat.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface SecurityService {

    User getUser(String username) throws UsernameNotFoundException;
}
