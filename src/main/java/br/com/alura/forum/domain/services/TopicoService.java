package br.com.alura.forum.domain.services;

import br.com.alura.forum.api.dtos.TopicoDto;
import br.com.alura.forum.api.dtos.TopicoFormDto;
import br.com.alura.forum.infra.mappers.MapStructMapper;
import br.com.alura.forum.infra.repositories.CursoRepository;
import br.com.alura.forum.infra.repositories.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final CursoRepository cursoRepository;
    private final MapStructMapper topicoMapper;

    public List<TopicoDto> getTopicos() {
        var topicos = topicoRepository.findAll();

        return TopicoDto.toDtoList(topicos);
    }

    public List<TopicoDto> getTopicosPorCurso(String nomeCurso) {
        var topicos = topicoRepository.findByCursoNome(nomeCurso);

        return TopicoDto.toDtoList(topicos);
    }

    @Transactional
    public void createTopico(TopicoFormDto topicoFormDto) {
        var topico = topicoMapper.toModel(topicoFormDto);
        topico.setCurso(cursoRepository.findByNome(topicoFormDto.getNomeCurso()));

        topicoRepository.save(topico);
    }

}
