package lucianonascimento.challenge02.controller.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record TransferRequest(
        @NotNull
        BigDecimal value,
        @NotNull
        Long payer,
        @NotNull
        Long payee
) {

}
