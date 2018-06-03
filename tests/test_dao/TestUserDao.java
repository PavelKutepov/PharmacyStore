package test_dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepov.com.dao.user_dao.User;
import pkutepov.com.dao.user_dao.UserInfo;
import pkutepov.com.dao.user_dao.UserService;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/testApplicationContext.xml")
public class TestUserDao {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void testUserDao() {
        List<User> userstest = new ArrayList<>();
        System.out.println("testUserDao");
        List<User> users = userService.getAllUsers();
        assertNotNull(users);


    }

    @Test
    public void testGetUserById() {
        System.out.println("testGetUserById");

        User user = userService.getUserById(52);
        assertNotNull(user);


    }
    @Test
    public void testAddUserInfo() {
        System.out.println("testAddUserInfo");
        UserInfo userInfo= new UserInfo("Кутепов1","Павел1","Леонидович1","23232232");

        assertNotNull(userInfo);
        System.out.println("testAddUser");
         userService.addUser("qweerty","Пsdfsdf",userInfo);



    }
    @Test
    public void testAddUser() {



    }
}
