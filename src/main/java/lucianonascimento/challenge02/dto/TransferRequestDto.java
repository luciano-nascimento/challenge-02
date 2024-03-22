package lucianonascimento.challenge02.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record TransferRequestDto(
        @NotNull
        BigDecimal value,
        @NotNull
        Long payer,
        @NotNull
        Long payee
) {

}
