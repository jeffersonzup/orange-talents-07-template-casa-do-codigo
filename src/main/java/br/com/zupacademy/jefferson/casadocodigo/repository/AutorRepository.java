package br.com.zupacademy.jefferson.casadocodigo.repository;

import br.com.zupacademy.jefferson.casadocodigo.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
