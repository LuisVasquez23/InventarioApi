package org.example.inventario.Application.Factory.Menu;

import org.example.inventario.Domain.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
