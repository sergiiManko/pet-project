package com.petproject.app;

import com.petproject.app.service.user.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sergii Manko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void createUser_isValid() {
        final String USER_NAME = "ipetrov";
        final String usernameAfterCreate = userService.createUser("Ivan Petrov", USER_NAME, "ipetrov@mail.com", "123456");
        Assert.assertEquals(USER_NAME, usernameAfterCreate);
    }
}
