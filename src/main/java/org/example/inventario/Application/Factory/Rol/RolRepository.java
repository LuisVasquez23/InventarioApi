package org.example.inventario.Application.Factory.Rol;

import org.example.inventario.Domain.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<Rol , Long> {

    @Query("SELECT r FROM Rol r WHERE r.Rol = :rol")
    Rol FindByRol(String rol);


}
