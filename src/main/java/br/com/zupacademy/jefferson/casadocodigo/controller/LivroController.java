package br.com.zupacademy.jefferson.casadocodigo.controller;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.LivroRequest;
import br.com.zupacademy.jefferson.casadocodigo.controller.data.response.DetalheLivroResponse;
import br.com.zupacademy.jefferson.casadocodigo.controller.data.response.LivroResponse;
import br.com.zupacademy.jefferson.casadocodigo.entity.Livro;
import br.com.zupacademy.jefferson.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.jefferson.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.jefferson.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<LivroResponse> listarLivros(){
        List<Livro> listaLivros = livroRepository.findAll();
        if(listaLivros.isEmpty()){
            return new ArrayList<>();
        }
        return LivroResponse.converterLivroToLivroResponseList(listaLivros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroResponse> detalharLivro(@PathVariable Long id){
        Optional<Livro> livroResponseEntity = livroRepository.findById(id);
        if (!livroResponseEntity.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Livro livro = livroResponseEntity.get();
        return ResponseEntity.ok().body(new DetalheLivroResponse(livro));
    }
}
