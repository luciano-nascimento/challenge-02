package lucianonascimento.challenge02.controller.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record TransferRequest(
    @NotNull
    double value,
    @NotNull
    Long payer,
    @NotNull
    Long payee
) {

}
