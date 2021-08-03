package br.com.zupacademy.jefferson.casadocodigo.controller;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.EstadoRequest;
import br.com.zupacademy.jefferson.casadocodigo.entity.Estado;
import br.com.zupacademy.jefferson.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.jefferson.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;

    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastraEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        Optional<Estado> existsByNomeEstado = estadoRepository.findByNomeEstado(estadoRequest.getNomeEstado());
        if(existsByNomeEstado.isPresent()){
            return ResponseEntity.badRequest().body("Estado já cadastrado");
        }
        Estado estado = estadoRequest.converterRequestToEntity(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok(estado);
    }

}
