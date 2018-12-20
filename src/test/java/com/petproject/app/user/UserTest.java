package com.petproject.app.user;

import com.petproject.app.model.User;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergii Manko
 */
public class UserTest {
    private static final String USER_NAME = "Ivan Ivanov";
    private static final String USER_LOGIN = "ivanov";
    private static final String USER_EMAIL = "i.ivanov@i.com";
    private static final String USER_PASSWORD = "123456";
    private static final Instant USER_UPDATED = Instant.now();

    @Test
    public void constructorTest() {
        final User user = new User(USER_NAME, USER_LOGIN, USER_EMAIL, USER_PASSWORD, USER_UPDATED);
        assertEquals(USER_NAME, user.getName());
        assertEquals(USER_LOGIN, user.getUsername());
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(USER_PASSWORD, user.getPassword());
        assertEquals(USER_UPDATED, user.getUpdatedAt());
    }
}
