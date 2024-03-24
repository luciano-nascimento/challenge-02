package lucianonascimento.challenge02.repository;

import java.util.Optional;
import lucianonascimento.challenge02.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  Optional<Account> findByUser(Long userId);
}
