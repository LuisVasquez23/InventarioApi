package org.example.inventario.Application.Factory.Menu;

import org.example.inventario.Domain.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    @Query("SELECT m FROM Menu m WHERE m.Nombre = :nombre")
    Menu findByName(String nombre);
}
