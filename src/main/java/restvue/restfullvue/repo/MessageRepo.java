package restvue.restfullvue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import restvue.restfullvue.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
