package domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record DadosCreateTopico (
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC") Instant dataCriacao,
        @NotNull Status status,
        @NotNull Long usuarioId,
        @NotNull Long cursoId
) {}
