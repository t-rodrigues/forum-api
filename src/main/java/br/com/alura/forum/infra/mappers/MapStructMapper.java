package br.com.alura.forum.infra.mappers;

import br.com.alura.forum.api.dtos.TopicoDto;
import br.com.alura.forum.api.dtos.TopicoFormDto;
import br.com.alura.forum.domain.models.Topico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Topico topicoFormToTopico(TopicoFormDto topicoFormDto);

    TopicoDto topicoToTopicoDto(Topico topico);

}
