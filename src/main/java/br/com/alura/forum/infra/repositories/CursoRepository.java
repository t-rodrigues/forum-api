package br.com.alura.forum.infra.repositories;

import br.com.alura.forum.domain.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);

}
