package br.com.zupacademy.jefferson.casadocodigo.controller;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.PaisRequest;
import br.com.zupacademy.jefferson.casadocodigo.entity.Pais;
import br.com.zupacademy.jefferson.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPais(@RequestBody @Valid PaisRequest paisRequest){
        Pais pais = new Pais(paisRequest.getNomePais());
        paisRepository.save(pais);
        return ResponseEntity.ok(pais.toString());
    }
}
