package br.com.zupacademy.jefferson.casadocodigo.repository;

import br.com.zupacademy.jefferson.casadocodigo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
