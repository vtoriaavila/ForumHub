package domain.resposta;

import domain.topico.DadosListTopico;
import domain.user.DadosListUser;

import java.time.Instant;

public record DadosListResposta(
        Long id,
        String mensagem,
        Instant dataCriacao,
        Boolean solucao,
        DadosListUser autor,
        DadosListTopico topico
) {
    public DadosListResposta(Resposta response) {
        this(
                response.getId(),
                response.getMensagem(),
                response.getDataCriacao(),
                response.getSolucao(),
                new DadosListUser(response.getAutor()),
                new DadosListTopico(response.getTopico())
        );
    }
}