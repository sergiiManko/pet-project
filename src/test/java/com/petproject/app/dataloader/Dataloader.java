package com.petproject.app.dataloader;

import com.petproject.app.model.Role;
import com.petproject.app.model.RoleName;
import com.petproject.app.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Sergii Manko
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Dataloader implements ApplicationRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(final ApplicationArguments args) {
        insertRoles();
    }

    private void insertRoles() {
        final Role roleUser = new Role(RoleName.ROLE_USER);
        roleRepository.save(roleUser);
        final Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        roleRepository.save(roleAdmin);
    }
}