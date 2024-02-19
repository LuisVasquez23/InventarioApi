package org.example.inventario.Application.Factory.Categoria;

import org.example.inventario.Domain.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
