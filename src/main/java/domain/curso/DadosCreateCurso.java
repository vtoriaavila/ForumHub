package domain.curso;


import jakarta.validation.constraints.NotBlank;

public record DadosCreateCurso(

        @NotBlank
        String nome,

        @NotBlank
        String categoria) {
}