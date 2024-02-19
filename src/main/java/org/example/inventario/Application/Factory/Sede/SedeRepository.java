package org.example.inventario.Application.Factory.Sede;

import org.example.inventario.Domain.Models.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SedeRepository extends JpaRepository<Sede,Long> {
    @Query("SELECT s FROM Sede s WHERE s.Nombre = :nombre")
    Sede FindByName(String nombre);
}
