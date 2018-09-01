package com.petproject.app.repository;

import com.petproject.app.model.Role;
import com.petproject.app.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Sergii Manko
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(final RoleName roleName);
}
