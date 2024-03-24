package lucianonascimento.challenge02.service.exception;

public class TransferFailedException extends RuntimeException{
  public TransferFailedException() {
    super("Transfer processing failed.");
  }
}
