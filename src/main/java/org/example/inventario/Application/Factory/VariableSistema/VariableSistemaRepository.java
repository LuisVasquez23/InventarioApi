package org.example.inventario.Application.Factory.VariableSistema;

import org.example.inventario.Domain.Models.VariableSistema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VariableSistemaRepository extends JpaRepository<VariableSistema, Long> {

}
