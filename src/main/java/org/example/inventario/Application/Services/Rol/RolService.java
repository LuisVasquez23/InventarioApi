package org.example.inventario.Application.Services.Rol;

import org.example.inventario.Domain.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolService extends JpaRepository<Rol , Long> {
}
