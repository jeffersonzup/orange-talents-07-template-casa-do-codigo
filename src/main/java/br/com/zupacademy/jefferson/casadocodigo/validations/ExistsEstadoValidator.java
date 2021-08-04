package br.com.zupacademy.jefferson.casadocodigo.validations;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.ClienteRequest;
import br.com.zupacademy.jefferson.casadocodigo.entity.Estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsEstadoValidator implements ConstraintValidator<ExistsEstado, ClienteRequest> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(ClienteRequest request, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT e FROM Estado e WHERE e.pais.id = :paisId", Estado.class);
        query.setParameter("paisId", request.getPaisId());
        List<Estado> list = query.getResultList();
        return (list.isEmpty() && (request.getEstadoId() == null)) || ((!list.isEmpty()) && (request.getEstadoId() != null));
    }
}
