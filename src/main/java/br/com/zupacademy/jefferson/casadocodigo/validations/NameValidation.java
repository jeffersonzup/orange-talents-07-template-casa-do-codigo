package br.com.zupacademy.jefferson.casadocodigo.validations;

import br.com.zupacademy.jefferson.casadocodigo.exceptions.BusinessRuleException;
import br.com.zupacademy.jefferson.casadocodigo.repository.CategoriaRepository;
import org.springframework.stereotype.Component;

@Component
public class NameValidation {

    private CategoriaRepository categoriaRepository;

    public NameValidation(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void validateExistingName(String nome){
        boolean existName = categoriaRepository.existsByNome(nome);
        if(existName){
            throw new BusinessRuleException("Já contém uma categoria cadastrada com o nome informado: " + nome);
        }
    }
}
