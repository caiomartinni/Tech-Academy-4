package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.Categoria_RequestDTO;
import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = this.categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }
    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        return this.categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Categoria_RequestDTO dto) {

        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());

        Categoria savedItem = categoriaRepository.save(categoria);
        return ResponseEntity.ok(savedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Categoria>categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Categoria não encontrado com o ID fornecido.");
        }
        categoriaRepository.deleteById(id);
        return ResponseEntity.ok().body("Categoria deletado com sucesso!");
    }
}