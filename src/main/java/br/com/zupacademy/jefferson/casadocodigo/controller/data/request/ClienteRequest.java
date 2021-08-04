package br.com.zupacademy.jefferson.casadocodigo.controller.data.request;

import br.com.zupacademy.jefferson.casadocodigo.entity.Cliente;
import br.com.zupacademy.jefferson.casadocodigo.entity.Estado;
import br.com.zupacademy.jefferson.casadocodigo.entity.Pais;
import br.com.zupacademy.jefferson.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.jefferson.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.jefferson.casadocodigo.validations.CpfOuCnpj;
import br.com.zupacademy.jefferson.casadocodigo.validations.ExistsEstado;
import br.com.zupacademy.jefferson.casadocodigo.validations.ExistsId;
import br.com.zupacademy.jefferson.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ExistsEstado
public class ClienteRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOuCnpj
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteRequest() {
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente converterRequestToEntity(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        @NotNull Pais pais = paisRepository.findById(paisId).get();
        if (estadoId == null) {
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
        } else {
            Estado estado = estadoRepository.findById(estadoId).get();
            Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
            cliente.setEstado(estado);
            return cliente;
        }

    }
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
