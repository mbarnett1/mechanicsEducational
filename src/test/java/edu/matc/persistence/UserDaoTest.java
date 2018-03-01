package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {

    UserDao dao;

    /**
     *  Set up
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();

        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL( "cleandb.sql");

    }




}
