package br.com.zupacademy.jefferson.casadocodigo.controller.data.request;

import br.com.zupacademy.jefferson.casadocodigo.entity.Estado;
import br.com.zupacademy.jefferson.casadocodigo.entity.Pais;
import br.com.zupacademy.jefferson.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.jefferson.casadocodigo.validations.ExistsId;
import br.com.zupacademy.jefferson.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nomeEstado;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public EstadoRequest() {
    }

    public EstadoRequest(String nomeEstado, Long paisId) {
        this.nomeEstado = nomeEstado;
        this.paisId = paisId;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado converterRequestToEntity(PaisRepository paisRepository) {
        @NotNull Pais pais = paisRepository.findById(paisId).get();
        return new Estado(nomeEstado, pais);
    }
}
