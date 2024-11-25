package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.model.Endereco;
import com.ecommerce.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para buscar um cliente por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
//        Optional<Cliente> cliente = clienteRepository.findById(id);
//        return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//    // Endpoint para criar um novo cliente
//    @PostMapping
//    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
//        Cliente clienteSalvo = clienteRepository.save(cliente);
//        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
//    }
//
//    // Endpoint para atualizar um cliente
//    @PutMapping("/{id}")
//    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
//        if (!clienteRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        cliente.setId(id); // Garantir que o ID seja atualizado corretamente
//        Cliente clienteAtualizado = clienteRepository.save(cliente);
//        return ResponseEntity.ok(clienteAtualizado);
//    }
//
//    // Endpoint para deletar um cliente
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
//        if (!clienteRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        clienteRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
