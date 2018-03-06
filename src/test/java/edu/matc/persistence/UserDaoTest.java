package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.Beam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserDaoTest {

    UserDao dao;

    /**
     *  Set up
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();

        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL( "cleandb2.sql");

    }

    /**
     * Verify get all users success
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(2, users.size());
    }


    /**
     * Verify get by user name success
     */
    @Test
    void searchByUserNameSuccess() {
        List<User> users = dao.searchByUserName("simpson");
        assertEquals(2, users.size());
    }

    /**
     * Verify get by id success
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertEquals("bsimpson", retrievedUser.getUserName());
    }


    /**
     * Method to test insert
     */
    @Test
    void insert() {
        User newUser = new User("msimpson", "pacifier");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("msimpson", insertedUser.getUserName());
    }

    /**
     * Method to test insert with beam
     */
    @Test
    void insertWithBeamSuccess() {

        User newUser = new User("msimpson", "pacifier");
        Beam beam = new Beam();
        newUser.addBeam(beam);

        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("msimpson", insertedUser.getUserName());
        assertEquals(1, insertedUser.getBeam().size());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Method to test update of user
     */
    @Test
    void updateSuccess() {
        String newPassword = "skateboard";
        User userToUpdate = dao.getById(1);
        userToUpdate.setPassword(newPassword);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(1);
        assertEquals(userToUpdate.getPassword(), retrievedUser.getPassword());
    }


    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

}
