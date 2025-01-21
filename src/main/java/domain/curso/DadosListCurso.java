package domain.curso;

public record DadosListCurso(
        Long id,
        String nome,
        String categoria
) {
    public DadosListCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}