package br.com.zupacademy.jefferson.casadocodigo.controller;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.AutorRequest;
import br.com.zupacademy.jefferson.casadocodigo.entity.Autor;
import br.com.zupacademy.jefferson.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.convertRequestToEntity(autorRequest);
        autorRepository.save(autor);
        return ResponseEntity.ok(autor.toString());
    }
}
