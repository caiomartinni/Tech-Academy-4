package com.ecommerce.ecommerce.controller;


import com.ecommerce.ecommerce.dto.ItemPedido_RequestDTO;
import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.ItemPedidoRespository;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ItemPedido")
public class ItemPedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRespository itemPedidoRepository;


    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll() {
        List<ItemPedido> itemPedidos = this.itemPedidoRepository.findAll();
        return ResponseEntity.ok(itemPedidos);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ItemPedido_RequestDTO dto) {

        ItemPedidoPK itemPedidoPK = new ItemPedidoPK();
        itemPedidoPK.setProdutoId(dto.getId_pedido());
        itemPedidoPK.setPedidoId(dto.getId_pedido());

        Optional<Produto> produtoOpt = produtoRepository.findById(dto.getId_produto());
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(dto.getId_pedido());



        if (produtoOpt.isEmpty() || pedidoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Item não encontrado com o ID fornecido.");
        }

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedidoOpt.get());
        itemPedido.setProduto(produtoOpt.get());
        itemPedido.setQuantidade(dto.getQuantidade());
        itemPedido.setId(itemPedidoPK);

        ItemPedido itempedidoSave = itemPedidoRepository.save(itemPedido);
        return ResponseEntity.ok(itempedidoSave);
    }
}
