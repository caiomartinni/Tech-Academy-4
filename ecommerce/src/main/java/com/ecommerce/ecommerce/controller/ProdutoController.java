package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
   private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

     @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return this.produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não foi encontrado"));
    }
}
