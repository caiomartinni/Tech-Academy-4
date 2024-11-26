package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Pedido;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedido = this.pedidoRepository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Pedido>pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Pedido não encontrado com o ID fornecido.");
        }
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok().body("Pedido deletado com sucesso!");
    }
}
