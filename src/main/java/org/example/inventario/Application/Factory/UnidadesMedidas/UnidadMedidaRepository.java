package org.example.inventario.Application.Factory.UnidadesMedidas;

import org.example.inventario.Domain.Models.UnidadMedidas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedidas, Long> {
}
