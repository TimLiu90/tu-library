package tim.tu.edu.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tim.tu.edu.library.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
