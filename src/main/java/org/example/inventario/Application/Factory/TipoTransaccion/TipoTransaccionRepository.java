package org.example.inventario.Application.Factory.TipoTransaccion;

import org.example.inventario.Domain.Models.TipoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoTransaccionRepository extends JpaRepository<TipoTransaccion,Long> {
}
