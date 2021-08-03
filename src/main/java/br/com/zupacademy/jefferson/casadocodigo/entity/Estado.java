package br.com.zupacademy.jefferson.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeEstado;

    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nomeEstado, Pais pais) {
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nomeEstado='" + nomeEstado + '\'' +
                ", pais=" + pais +
                '}';
    }
}
