package lucianonascimento.challenge02.service;

import lucianonascimento.challenge02.model.Account;
import lucianonascimento.challenge02.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public Account getAccount(Long accountId) {
    return this.accountRepository.findByUser(accountId)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Account not found with id " + accountId)
        );
  }

  public void updateBalance(Account account, double value) {
    account.setBalance(value);
    accountRepository.save(account);
  }
}
