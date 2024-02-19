package org.example.inventario.Application.Factory.Estante;

import org.example.inventario.Domain.Models.Estante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstanteRepository extends JpaRepository<Estante, Long> {
}
