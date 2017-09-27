package tim.tu.edu.library.service;

import tim.tu.edu.library.domain.Role;

public interface RoleService {

    public Role saveRole(Role role);
    public Role findByRole(String role);
}
