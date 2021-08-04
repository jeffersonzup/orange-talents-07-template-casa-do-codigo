package br.com.zupacademy.jefferson.casadocodigo.controller;

import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.ClienteRequest;
import br.com.zupacademy.jefferson.casadocodigo.controller.data.request.EstadoRequest;
import br.com.zupacademy.jefferson.casadocodigo.entity.Cliente;
import br.com.zupacademy.jefferson.casadocodigo.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    private PaisRepository paisRepository;

    private EstadoRepository estadoRepository;
    

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraCliente(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.converterRequestToEntity(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente.getId());
    }

}
