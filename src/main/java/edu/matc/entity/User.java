package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Beam> beam = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name= "native", strategy = "native")
    private int id;

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public Set<Beam> getBeam() {
        return beam;
    }

    public void setBeam(Set<Beam> beam) {
        this.beam = beam;
    }


    public void addBeam(Beam beam1) {
        beam.add(beam1);
        beam1.setUser(this);
    }

    public void removeOrder(Beam beam1) {
        beam.add(beam1);
        beam1.setUser(null);
    }





}
