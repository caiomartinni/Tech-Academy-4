package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Cliente;
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

//    @GetMapping("/{id}")
//    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
//        Optional<Categoria> categoria = categoriaRepository.findById(id);
//        return categoria.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
//        Categoria categoriaSalva = categoriaRepository.save(categoria);
//        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
//        if (!categoriaRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        categoria.setId(id);
//        Categoria categoriaAtualizada = categoriaRepository.save(categoria);
//        return ResponseEntity.ok(categoriaAtualizada);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
//        if (!categoriaRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        categoriaRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
