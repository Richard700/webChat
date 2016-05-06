package com.chat.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "chat_user")
public class UserEntity implements Serializable {

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

//    @ManyToMany
//    @JoinTable(
//            name = "user_to_user",
//            joinColumns = {@JoinColumn(name = "user_from", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_to", referencedColumnName = "id")}
//    )
//    private List<User> friends;

    public UserEntity() {
    }

//    public UserEntity(UserEntity user) {
//        this(user.getId(), user.getFirstName(), user.getSecondName(), user.getLogin(), user.getPassword(), user.getToken());
//    }

//    public UserEntity(Long id, String firstName, String secondName, String login, String password, String token) {
//        this.id = id;
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.login = login;
//        this.password = password;
//        this.token = token;
//    }
//
//    public UserEntity(String firstName, String secondName, String login, String password, String token) {
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.login = login;
//        this.password = password;
//        this.token = token;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(token, user.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, login, password, token);
    }
}
