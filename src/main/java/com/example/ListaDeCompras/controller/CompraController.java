package com.example.ListaDeCompras.controller;

import com.example.ListaDeCompras.model.Compra;
import com.example.ListaDeCompras.service.CompraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@Valid @RequestBody Compra compra) {
        Compra novaCompra = compraService.criarCompra(compra);
        return new ResponseEntity<>(novaCompra, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        return ResponseEntity.ok(compraService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizarCompra(@PathVariable Long id, @Valid @RequestBody Compra compra) {
        Compra compraAtualizada = compraService.atualizarCompra(id, compra);
        return ResponseEntity.ok(compraAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCompra(@PathVariable Long id) {
        compraService.excluirCompra(id);
        return ResponseEntity.noContent().build();
    }
}