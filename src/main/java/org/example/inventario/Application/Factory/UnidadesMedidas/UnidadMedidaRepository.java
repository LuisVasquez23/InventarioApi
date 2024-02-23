package org.example.inventario.Application.Factory.UnidadesMedidas;

import org.example.inventario.Domain.Models.UnidadMedidas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedidas, Long> {
    Optional<UnidadMedidas> GetMedidaByName(String name);
}
