package br.com.zupacademy.jefferson.casadocodigo.controller.data.request;

import br.com.zupacademy.jefferson.casadocodigo.entity.Pais;
import br.com.zupacademy.jefferson.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
    private String nomePais;

    public PaisRequest() {
    }

    public PaisRequest(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getNomePais() {
        return nomePais;
    }
}
