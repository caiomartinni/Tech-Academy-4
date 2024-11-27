package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.Endereco_RequestDTO;
import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.model.Endereco;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.ClienteRepository;
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

    @Autowired
    private ClienteRepository clienteRepository;

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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Endereco_RequestDTO dto) {

        Endereco endereco = new Endereco();
        endereco.setBairro(dto.getBairro());
        endereco.setCep(dto.getCep());
        endereco.setCidade(dto.getCidade());
        endereco.setLogr(dto.getLogr());
        endereco.setUf(dto.getUf());
        endereco.setNumero(dto.getNumero());

        Endereco saveEndereco = enderecoRepository.save(endereco);
        return ResponseEntity.ok(saveEndereco);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Endereco>enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Endereço não encontrado com o ID fornecido pelo usuario.");
        }
        enderecoRepository.deleteById(id);
        return ResponseEntity.ok().body("Endereço deletado com sucesso!");
    }
}
