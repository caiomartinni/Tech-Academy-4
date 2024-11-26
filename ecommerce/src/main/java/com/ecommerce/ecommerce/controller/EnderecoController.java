package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Endereco;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Endpoint para listar todos os endereços
    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> enderecos = this.enderecoRepository.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public Endereco findById(@PathVariable Integer id) {
        return this.enderecoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Endereço não foi encontrado"));
    }
}
