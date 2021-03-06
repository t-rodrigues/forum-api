package br.com.alura.forum.api.controllers;

import br.com.alura.forum.api.dtos.TopicoDto;
import br.com.alura.forum.api.dtos.TopicoFormDto;
import br.com.alura.forum.domain.services.TopicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
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

    @GetMapping("/{curso}")
    public List<TopicoDto> getTopicosPorCurso(@PathVariable String curso) {
        return topicoService.getTopicosPorCurso(curso);
    }

    @PostMapping
    public ResponseEntity<TopicoDto> createTopico(@RequestBody @Valid TopicoFormDto topicoFormDto,
            UriComponentsBuilder uriBuilder) {
        TopicoDto topicoDto = topicoService.createTopico(topicoFormDto);

        URI location = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoDto.getId()).toUri();

        return ResponseEntity.created(location).body(topicoDto);
    }

}
