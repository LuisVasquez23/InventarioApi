package org.example.inventario.Application.Factory.Estante;

import org.example.inventario.Domain.Models.Estante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstanteRepository extends JpaRepository<Estante, Long> {
    @Query("SELECT e FROM Estante e WHERE e.Nombre = :nombre")

    Estante findByName(String nombre);
}
