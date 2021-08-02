package br.com.zupacademy.jefferson.casadocodigo.controller.data.response;

import br.com.zupacademy.jefferson.casadocodigo.entity.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private Long id;
    private String titulo;

    public LivroResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public static List<LivroResponse> converterLivroToLivroResponseList(List<Livro> listaLivros) {
        return listaLivros.stream()
                .map(livro -> new LivroResponse(livro.getId(), livro.getTitulo()))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
