package domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosUpdateStatusTopico (
        @NotNull Long id,
        @NotNull Status status
) {
}