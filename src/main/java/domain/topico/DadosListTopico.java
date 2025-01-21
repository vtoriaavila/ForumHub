package domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import domain.curso.DadosListCurso;
import domain.user.DadosListUser;

import java.time.Instant;

public record DadosListTopico(
        Long id,
        String titulo,
        String mensagem,
        Status status,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
        Instant dataCriacao,
        DadosListUser user,
        DadosListCurso curso
) {
    public DadosListTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getStatus(),
                topico.getDataCriacao(),
                new DadosListUser(topico.getUser()),
                new DadosListCurso(topico.getCurso()));
    }
}