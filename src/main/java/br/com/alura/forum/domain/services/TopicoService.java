package br.com.alura.forum.domain.services;

import br.com.alura.forum.api.dtos.TopicoDto;
import br.com.alura.forum.infra.repositories.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public List<TopicoDto> getTopicos() {
        var topicos = topicoRepository.findAll();

        return TopicoDto.toDtoList(topicos);
    }

}
