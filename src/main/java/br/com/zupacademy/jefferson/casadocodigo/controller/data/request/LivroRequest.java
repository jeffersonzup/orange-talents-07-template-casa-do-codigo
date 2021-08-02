package br.com.zupacademy.jefferson.casadocodigo.controller.data.request;

import br.com.zupacademy.jefferson.casadocodigo.entity.Autor;
import br.com.zupacademy.jefferson.casadocodigo.entity.Categoria;
import br.com.zupacademy.jefferson.casadocodigo.entity.Livro;
import br.com.zupacademy.jefferson.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.jefferson.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.jefferson.casadocodigo.validations.ExistsId;
import br.com.zupacademy.jefferson.casadocodigo.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    @Column(columnDefinition = "text")
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                        @NotBlank String sumario, @NotNull @Min(value=20) BigDecimal preco,
                        @Min(value = 100) Integer numeroPaginas, @NotBlank String isbn,
                        @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro convertLivroRequestToLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        @NotNull Autor autor = autorRepository.findById(idAutor).get();
        @NotNull Categoria categoria = categoriaRepository.findById(idCategoria).get();
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
    }
}
