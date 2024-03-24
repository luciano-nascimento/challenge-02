package lucianonascimento.challenge02.apiClient;

import lucianonascimento.challenge02.apiClient.dto.TransferAuthorizationResponse;
import lucianonascimento.challenge02.apiClient.dto.TransferNotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "transfer-notification-service",
    url = "https://run.mocky.io"
)
public interface TransferNotificationClient {

  @GetMapping("/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
  TransferNotificationResponse sendTransferNotification();
}
