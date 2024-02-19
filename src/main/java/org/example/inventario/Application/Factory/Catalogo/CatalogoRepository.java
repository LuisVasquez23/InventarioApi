package org.example.inventario.Application.Factory.Catalogo;

import org.example.inventario.Domain.Models.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
    @Query("SELECT c FROM Catalogo c WHERE c.Nombre = :nombre")
    Catalogo FindByName(String nombre);
}
