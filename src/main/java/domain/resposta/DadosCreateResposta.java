package domain.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCreateResposta(

        @NotBlank
        String mensagem,

        @NotNull
        Boolean solucao,

        @NotNull
        Long autorId,

        @NotNull
        Long topicoId
) {
}
