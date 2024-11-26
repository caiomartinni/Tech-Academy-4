package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.model.Endereco;
import com.ecommerce.ecommerce.model.Produto;
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
    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id) {
        return this.clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não foi encontrado"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Cliente>clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Cliente não encontrado com o ID fornecido.");
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().body("Cliente deletado com sucesso!");
    }
}

