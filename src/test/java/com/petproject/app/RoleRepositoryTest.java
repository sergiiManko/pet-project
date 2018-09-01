package com.petproject.app;

import com.petproject.app.model.Role;
import com.petproject.app.model.RoleName;
import com.petproject.app.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Sergii Manko
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void saveRoleTest() {
        roleRepository.save(new Role(RoleName.ROLE_USER));
    }
}
