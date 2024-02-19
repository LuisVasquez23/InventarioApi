package org.example.inventario.Application.Factory.Catalogo;

import org.example.inventario.Domain.Models.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
}
