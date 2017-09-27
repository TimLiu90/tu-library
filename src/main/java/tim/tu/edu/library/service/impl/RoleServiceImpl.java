package tim.tu.edu.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim.tu.edu.library.domain.Role;
import tim.tu.edu.library.repository.RoleRepository;
import tim.tu.edu.library.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    /**
     * Save role to database
     * @param role
     * @return
     */
    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Find role by role name.
     *
     * @param role
     * @return
     */
    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
