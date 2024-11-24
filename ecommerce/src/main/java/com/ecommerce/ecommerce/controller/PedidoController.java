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
}
