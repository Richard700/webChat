package com.chat.dao.entity;

/**
 * Created by vlad
 * Date: 04.06.15_11:29
 */
public interface UserI {

    Long getId();

    String getPassword();

    String getToken();

    String getFirstName();

    String getSecondName();

    String getLogin();
}
