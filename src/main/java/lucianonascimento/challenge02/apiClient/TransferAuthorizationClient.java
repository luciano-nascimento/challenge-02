package lucianonascimento.challenge02.apiClient;

import lucianonascimento.challenge02.apiClient.dto.TransferAuthorizationResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@todo
//move url to envfile
@FeignClient(
        name = "transfer-authorization-service",
        url = "https://run.mocky.io"
)
public interface TransferAuthorizationClient {
    @GetMapping("/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
    TransferAuthorizationResponse getTransferAuthorization();
}