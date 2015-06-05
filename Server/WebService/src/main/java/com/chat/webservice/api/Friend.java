package com.chat.webservice.api;

import java.util.Objects;

/**
 * Created by vlad
 * Date: 05.06.15_13:57
 */
public class Friend implements FriendI{

    private String login;
    private String firstName;
    private String secondName;

    public Friend() {
    }

    public Friend(String login, String firstName, String secondName) {
        this.login = login;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, firstName, secondName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Friend other = (Friend) obj;
        return Objects.equals(this.login, other.login) && Objects.equals(this.firstName, other.firstName) && Objects.equals(this.secondName, other.secondName);
    }
}
