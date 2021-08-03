package br.com.zupacademy.jefferson.casadocodigo.repository;

import br.com.zupacademy.jefferson.casadocodigo.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
