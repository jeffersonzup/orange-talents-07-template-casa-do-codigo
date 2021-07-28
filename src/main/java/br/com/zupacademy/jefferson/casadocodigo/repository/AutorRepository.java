package br.com.zupacademy.jefferson.casadocodigo.repository;

import br.com.zupacademy.jefferson.casadocodigo.entity.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}
