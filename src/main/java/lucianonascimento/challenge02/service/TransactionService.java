package lucianonascimento.challenge02.service;

import lucianonascimento.challenge02.controller.dto.TransferRequest;
import lucianonascimento.challenge02.model.Transaction;
import lucianonascimento.challenge02.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  public void createTransaction (TransferRequest transferRequest) {
    Transaction transaction = new Transaction();
    transaction.setFromAccountId(transferRequest.payer());
    transaction.setToAccountId(transferRequest.payee());
    transactionRepository.save(transaction);
  }

}
