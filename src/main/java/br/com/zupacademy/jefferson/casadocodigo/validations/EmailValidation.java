package br.com.zupacademy.jefferson.casadocodigo.validations;

import br.com.zupacademy.jefferson.casadocodigo.exceptions.BusinessRuleException;
import br.com.zupacademy.jefferson.casadocodigo.repository.AutorRepository;
import org.springframework.stereotype.Component;

@Component
public class EmailValidation {

    private AutorRepository autorRepository;

    public EmailValidation(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void validateExistingEmail(String email){
        boolean existEmail = autorRepository.existsByEmail(email);
        if(existEmail){
            throw new BusinessRuleException("Já existe um Autor cadastrado para o e-mail informado: " + email);
        }
    }
}
