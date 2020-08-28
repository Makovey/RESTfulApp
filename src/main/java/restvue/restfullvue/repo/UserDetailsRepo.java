package restvue.restfullvue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import restvue.restfullvue.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
