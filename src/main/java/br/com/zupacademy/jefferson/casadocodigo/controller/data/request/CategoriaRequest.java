package br.com.zupacademy.jefferson.casadocodigo.controller.data.request;

import br.com.zupacademy.jefferson.casadocodigo.entity.Categoria;
import br.com.zupacademy.jefferson.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public CategoriaRequest() {
    }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria convertCategoriaRequestToEntity(CategoriaRequest categoriaRequest){
        return new Categoria(this.nome);
    }

}
