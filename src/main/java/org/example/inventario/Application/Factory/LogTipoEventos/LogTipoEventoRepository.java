package org.example.inventario.Application.Factory.LogTipoEventos;

import org.example.inventario.Domain.Models.LogTipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogTipoEventoRepository extends JpaRepository<LogTipoEvento, Long> {
}
