package br.com.alura.forum.api.controllers;

import br.com.alura.forum.api.dtos.TopicoDto;
import br.com.alura.forum.domain.services.TopicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    private final TopicoService topicoService;

    public TopicosController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public List<TopicoDto> getTopicos() {
        return topicoService.getTopicos();
    }

}
