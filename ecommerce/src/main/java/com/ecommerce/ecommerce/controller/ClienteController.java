package com.ecommerce.ecommerce.controller;

import ch.qos.logback.core.net.server.Client;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Cliente>clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Cliente não encontrado com o ID fornecido.");
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().body("Cliente deletado com sucesso!");
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cliente_RequestDTO dto){

        Optional<Endereco> enderecoOptional = enderecoRepository.findById(dto.getEndereco());

        if (enderecoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Cliente não encontrado com o ID fornecido.");
        }

        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setEndereco(enderecoOptional.get());



        Cliente saveCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(saveCliente);
    }
}

