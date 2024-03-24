package lucianonascimento.challenge02.service;

import jakarta.transaction.Transactional;
import lucianonascimento.challenge02.apiClient.TransferAuthorizationClient;
import lucianonascimento.challenge02.apiClient.TransferNotificationClient;
import lucianonascimento.challenge02.apiClient.dto.TransferAuthorizationResponse;
import lucianonascimento.challenge02.apiClient.dto.TransferNotificationResponse;
import lucianonascimento.challenge02.controller.dto.TransferRequest;
import lucianonascimento.challenge02.model.Account;
import lucianonascimento.challenge02.model.AccountTypeEnum;
import lucianonascimento.challenge02.service.exception.TransferFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TransferService {

  @Autowired
  private AccountService accountService;
  @Autowired
  private TransferAuthorizationClient transferAuthorizationClient;
  @Autowired
  private TransferNotificationClient transferNotificationClient;

  @Autowired
  private TransactionService transactionService;

  public static final String TRANSFR_AUTHORIZATION_OK = "Autorizado";

  @Transactional
  public void transfer(TransferRequest transferRequestDto) {

    Account fromAccount = this.accountService.getAccount(transferRequestDto.payer());
    this.transferValidation(fromAccount, transferRequestDto);

    try {
      accountService.updateBalance(
          fromAccount, fromAccount.getBalance() - transferRequestDto.value()
      );

      Account toAccount = accountService.getAccount(transferRequestDto.payee());
      accountService.updateBalance(
          toAccount, toAccount.getBalance() + transferRequestDto.value()
      );

      transactionService.createTransaction(transferRequestDto);
    } catch (Exception exception) {
      throw new TransferFailedException();
    }

    TransferNotificationResponse transferNotificationResponse =
        this.transferNotificationClient.sendTransferNotification();

  }

  private void transferValidation(Account fromAccount, TransferRequest transferRequest){
    if (fromAccount.getBalance() < transferRequest.value()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Account balance is not enough.");
    }

    if (!fromAccount.getType().equals(AccountTypeEnum.DEFAULT)) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "This account can't make transfers.");
    }

    try {
      TransferAuthorizationResponse transferAuthorizationResponse =
          this.transferAuthorizationClient.getTransferAuthorization();
      if (!transferAuthorizationResponse.message().equals(TRANSFR_AUTHORIZATION_OK)) {
        throw new ResponseStatusException(
            HttpStatus.FORBIDDEN, "Transfer not authorized.");
      }
    } catch (Exception exception){
      throw new ResponseStatusException(
          HttpStatus.SERVICE_UNAVAILABLE, "Authorization service is not responding.");
    }
  }
}
