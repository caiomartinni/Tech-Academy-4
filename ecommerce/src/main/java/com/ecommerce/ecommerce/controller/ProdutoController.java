package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.Produto_RequesDTO;
import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

     @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id) {
        return this.produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não foi encontrado"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Produto>produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Produto não encontrado com o ID fornecido.");
        }
        produtoRepository.deleteById(id);
    return ResponseEntity.ok().body("Produto deletado com sucesso!");
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Produto_RequesDTO dto){

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(dto.getId_categoria());

        if (categoriaOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Produto não encontrado com o ID fornecido.");
        }

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(categoriaOptional.get());

        Produto saveProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(saveProduto);
    }
}
