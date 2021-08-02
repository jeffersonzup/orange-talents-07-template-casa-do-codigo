package br.com.zupacademy.jefferson.casadocodigo.controller;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.LivroRequest;
import br.com.zupacademy.jefferson.casadocodigo.entity.Livro;
import br.com.zupacademy.jefferson.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.jefferson.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.jefferson.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository livroRepository;

    private AutorRepository autorRepository;

    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro = livroRequest.convertLivroRequestToLivro(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok(livro);
    }
}
