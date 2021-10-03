package br.com.alura.forum.api.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoFormDto {

    private String titulo;
    private String mensagem;

    @JsonAlias("nome_curso")
    private String nomeCurso;

}