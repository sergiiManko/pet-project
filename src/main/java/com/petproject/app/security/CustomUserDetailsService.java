package com.petproject.app.security;

import com.petproject.app.model.User;
import com.petproject.app.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Sergii Manko
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String usernameOrEmail) throws UsernameNotFoundException {
        final User user = userService.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );
        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(final Long id) {
        final User user = userService.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id));
        return UserPrincipal.create(user);
    }
}
