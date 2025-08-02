package com.example.ListaDeCompras.repository;

import com.example.ListaDeCompras.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
