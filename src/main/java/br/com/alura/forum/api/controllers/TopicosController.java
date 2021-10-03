package br.com.alura.forum.api.controllers;

import br.com.alura.forum.api.dtos.TopicoDto;
import br.com.alura.forum.domain.models.Curso;
import br.com.alura.forum.domain.models.Topico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @GetMapping
    public List<TopicoDto> getTopicos() {
        Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));

        return TopicoDto.toDtoList(Arrays.asList(topico, topico, topico));
    }

}
