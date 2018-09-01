package com.petproject.app;

import com.petproject.app.model.User;
import com.petproject.app.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

/**
 * @author Sergii Manko
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        userRepository.save(new User("Ivan Ivanov", "iivanov", "email@mail.com", "123456", Instant.now()));
    }
}
