package com.petproject.app.rest;

import com.petproject.app.AppApplication;
import com.petproject.app.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Sergii Manko
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerTest {

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    @Test
    public void signup_isSuccess() {
        final String username = "ipetrov";
        final User user = new User("Ivan Petrov", username, "ipetrov@mail.com", "123456", Instant.now());
        final HttpEntity<User> entity = new HttpEntity<>(user, headers);
        final ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/auth/signup"), HttpMethod.POST, entity, String.class);
        final String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("/api/users/" + username));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("{\"success\":true,\"message\":\"User registered successfully\"}", response.getBody());
    }

    private String createURLWithPort(final String uri) {
        return "http://localhost:" + port + uri;
    }
}
