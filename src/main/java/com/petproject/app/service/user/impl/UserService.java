package com.petproject.app.service.user.impl;

import com.petproject.app.exception.AppException;
import com.petproject.app.model.Role;
import com.petproject.app.model.RoleName;
import com.petproject.app.model.User;
import com.petproject.app.repository.RoleRepository;
import com.petproject.app.repository.UserRepository;
import com.petproject.app.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.Optional;

/**
 * Implementation business logic of user model.
 *
 * @author Sergii Manko
 * @see IUserService
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /**
     * @see IUserService#findByUsernameOrEmail
     */
    @Override
    public Optional<User> findByUsernameOrEmail(final String username, final String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }

    /**
     * @see IUserService#findById
     */
    @Override
    public Optional<User> findById(final Long userId) {
        return userRepository.findById(userId);
    }

    /**
     * @see IUserService#existsByUsername
     */
    @Override
    public Boolean existsByUsername(final String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * @see IUserService#existsByEmail
     */
    @Override
    public Boolean existsByEmail(final String email) {
        return userRepository.existsByEmail(email);
    }

    /**
     * @see IUserService#createUser
     */
    @Override
    public String createUser(final String name, final String username, final String email, final String password) {
        final User user = new User(name, username, email, new BCryptPasswordEncoder().encode(password), Instant.now());
        final Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(
                () -> new AppException("User role not set.")
        );
        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user).getUsername();
    }
}
