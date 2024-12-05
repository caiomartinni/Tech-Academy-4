package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.Cliente_RequestDTO;
import com.ecommerce.ecommerce.dto.Pedido_RequestDTO;
import com.ecommerce.ecommerce.dto.Produto_RequesDTO;
import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.model.Pedido;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.ClienteRepository;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedido = this.pedidoRepository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pedido_RequestDTO dto) {

        if (dto.getTotal() == null ) {
            return ResponseEntity.badRequest().body("O valor do pedido é obrigatório.");
        }



        Optional<Cliente> clienteOptional = clienteRepository.findById(dto.getClienteId());

        Pedido pedido = new Pedido();
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setTotal(dto.getTotal());
        pedido.setCliente(clienteOptional.get());

        Pedido savepedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(savepedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Pedido_RequestDTO dto) {

        Optional<Pedido> itemOpt = pedidoRepository.findById(id);
        if (itemOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Pedido não encontrado com o ID fornecido.");
        }

        Optional<Cliente> clienteOptional = clienteRepository.findById(dto.getClienteId());

        Pedido pedido = itemOpt.get();
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setTotal(dto.getTotal());
        pedido.setCliente(clienteOptional.get());

        //  realizar o updade do item
        Pedido savedItem = pedidoRepository.save(pedido);
        return ResponseEntity.ok(savedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Pedido>pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Pedido não encontrado com o ID fornecido pelo Usuario.");
        }
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok().body("Pedido deletado com sucesso!");
    }


}
