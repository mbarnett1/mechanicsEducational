package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 *  A class to represent a user.
 *
 *  @author mbarnett1
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;


    private int id;

    public User() {

    }

    public User(String userName, String password, String id) {

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
