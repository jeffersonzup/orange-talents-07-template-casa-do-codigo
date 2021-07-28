package br.com.zupacademy.jefferson.casadocodigo.controller.data.request;

import br.com.zupacademy.jefferson.casadocodigo.entity.Autor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest() {
    }

    public AutorRequest(
            @NotBlank String nome,
            @NotBlank @Email String email,
            @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor convertRequestToEntity() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
