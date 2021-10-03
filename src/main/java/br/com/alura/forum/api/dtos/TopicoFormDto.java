package br.com.alura.forum.api.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TopicoFormDto {

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotNull
    @JsonAlias("curso_id")
    private Long cursoId;

}
