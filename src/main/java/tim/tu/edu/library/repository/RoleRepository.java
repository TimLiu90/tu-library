package tim.tu.edu.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim.tu.edu.library.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String > {

    public Role findByRole(String role);
}
