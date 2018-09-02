package com.petproject.app.service.user;

import com.petproject.app.model.User;

import java.util.Optional;

/**
 * Interface provide methods for business logic of user model.
 *
 * @author Sergii Manko
 */
public interface IUserService {

    /**
     * Method needed for find User by username or email.
     *
     * @param username User name
     * @param email    User email
     * @return Optional<User>
     */
    Optional<User> findByUsernameOrEmail(final String username, final String email);

    /**
     * Method needed for find User by id.
     *
     * @param userId User id
     * @return Optional<User>
     */
    Optional<User> findById(final Long userId);

    /**
     * Method needed for find User by username.
     *
     * @param username User name
     * @return Boolean
     */
    Boolean existsByUsername(final String username);

    /**
     * Method needed for find User by email.
     *
     * @param email User email
     * @return Boolean
     */
    Boolean existsByEmail(final String email);

    /**
     * Method needed for create User.
     *
     * @param email User email
     * @return Boolean
     */

    String createUser(final String name, final String username, final String email, final String password);
}
