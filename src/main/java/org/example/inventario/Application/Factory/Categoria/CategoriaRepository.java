package org.example.inventario.Application.Factory.Categoria;

import org.example.inventario.Domain.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT c FROM Categoria c WHERE c.Categoria = :categoria")
    Categoria findByCategoria(String categoria);
}
