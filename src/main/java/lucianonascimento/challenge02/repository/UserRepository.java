package lucianonascimento.challenge02.repository;

import lucianonascimento.challenge02.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
