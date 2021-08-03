package br.com.zupacademy.jefferson.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nomePais;

    public Pais() {
    }

    public Pais(String nomePais) {
        this.nomePais = nomePais;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nomePais='" + nomePais + '\'' +
                '}';
    }
}
