package br.com.zupacademy.jefferson.casadocodigo.controller;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.CategoriaRequest;
import br.com.zupacademy.jefferson.casadocodigo.entity.Categoria;
import br.com.zupacademy.jefferson.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.jefferson.casadocodigo.validations.NameValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    private NameValidation nameValidation;

    public CategoriaController(CategoriaRepository categoriaRepository, NameValidation nameValidation) {
        this.categoriaRepository = categoriaRepository;
        this.nameValidation = nameValidation;
    }

    @PostMapping
    @Transactional
    public ResponseEntity criaCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){
        nameValidation.validateExistingName(categoriaRequest.getNome());
        Categoria categoria = categoriaRequest.convertCategoriaRequestToEntity(categoriaRequest);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoria.toString());
    }

}
