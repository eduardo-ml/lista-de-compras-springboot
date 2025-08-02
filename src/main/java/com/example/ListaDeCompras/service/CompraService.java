package com.example.ListaDeCompras.service;

// Corrigindo o nome da exceção importada
import com.example.ListaDeCompras.exception.RecursoNaoEncontradoExcecao;
import com.example.ListaDeCompras.model.Compra;
import com.example.ListaDeCompras.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {
    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    public Compra criarCompra(Compra compra) {
        return repository.save(compra);
    }

    public List<Compra> listarTodas() {
        return repository.findAll();
    }

    public Compra pegarId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoExcecao("Compra com id " + id + " não encontrada."));
    }

    public Compra atualizarCompra(Long id, Compra compraAtualizada) {
        Compra compraExistente = pegarId(id);
        compraExistente.setNome(compraAtualizada.getNome());
        compraExistente.setQuantidade(compraAtualizada.getQuantidade());
        compraExistente.setComprado(compraAtualizada.isComprado());
        return repository.save(compraExistente);
    }

    public void excluirCompra(Long id) {
        pegarId(id);
        repository.deleteById(id);
    }
}