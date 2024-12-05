package com.ecommerce.ecommerce.controller;

import ch.qos.logback.core.net.server.Client;
import com.ecommerce.ecommerce.dto.Categoria_RequestDTO;
import com.ecommerce.ecommerce.dto.Cliente_RequestDTO;
import com.ecommerce.ecommerce.dto.Produto_RequesDTO;
import com.ecommerce.ecommerce.model.Categoria;
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
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cliente_RequestDTO dto) {

        Optional<Endereco> enderecoOpt = enderecoRepository.findById(dto.getEndereco());

        Cliente cliente = new Cliente();
        cliente.setEmail(dto.getEmail());
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(enderecoOpt.get());

        Cliente saveCleinte = clienteRepository.save(cliente);
        return ResponseEntity.ok(saveCleinte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente_RequestDTO dto){

        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        Optional<Endereco> enderecoOpt = enderecoRepository.findById(dto.getEndereco());

        Cliente cliente = clienteOpt.get();
        cliente.setEmail(dto.getEmail());
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(enderecoOpt.get());

        Cliente saveCleinte = clienteRepository.save(cliente);
        return ResponseEntity.ok(saveCleinte);
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

