package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Endereco;
import com.ecommerce.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Endpoint para listar todos os endereços
    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    // Endpoint para buscar um endereço por ID
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo endereço
    @PostMapping
    public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
    }

    // Endpoint para atualizar um endereço
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Integer id, @RequestBody Endereco endereco) {
        if (!enderecoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        endereco.setId(id); // Garantir que o ID seja atualizado corretamente
        Endereco enderecoAtualizado = enderecoRepository.save(endereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    // Endpoint para deletar um endereço
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!enderecoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        enderecoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
