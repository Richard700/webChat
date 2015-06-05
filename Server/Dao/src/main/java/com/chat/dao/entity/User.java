package com.chat.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by vlad
 * Date: 04.06.15_11:28
 */
@Entity
@Table(name = "chat_user")
public class User implements UserI, Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "token")
    private String token;

    @ManyToMany
    @JoinTable(
            name = "user_to_user",
            joinColumns = {@JoinColumn(name = "user_from", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_to", referencedColumnName = "id")}
    )
    private List<User> friends;

    public User() {
    }

    public User(UserI user) {
        this(user.getId(), user.getFirstName(), user.getSecondName(), user.getLogin(), user.getPassword(), user.getToken());
    }

    public User(Long id, String firstName, String secondName, String login, String password, String token) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.token = token;
    }

    public User(String firstName, String secondName, String login, String password, String token) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getToken() {
        return token;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<User> getFriends() {
        return friends;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, login, password, token);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.firstName, other.firstName) && Objects.equals(this.secondName, other.secondName) && Objects.equals(this.login, other.login) && Objects.equals(this.password, other.password) && Objects.equals(this.token, other.token);
    }

}
