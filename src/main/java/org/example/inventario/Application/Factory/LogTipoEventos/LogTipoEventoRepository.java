package org.example.inventario.Application.Factory.LogTipoEventos;

import org.example.inventario.Domain.Models.LogTipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LogTipoEventoRepository extends JpaRepository<LogTipoEvento, Long> {
    @Query("SELECT l FROM LogTipoEvento l WHERE l.Tipo = :tipo")
    LogTipoEvento findByTipo (String tipo);

}
