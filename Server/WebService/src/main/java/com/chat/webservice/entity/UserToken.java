package com.chat.webservice.entity;

import java.util.Objects;

/**
 * Created by vlad
 * Date: 03.06.15_16:11
 */
public class UserToken implements UserTokenI {

    private String token;

    public UserToken() {
    }

    public UserToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserToken{");
        sb.append("token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final UserToken other = (UserToken) obj;
        return Objects.equals(this.token, other.token);
    }
}
