package org.example.inventario.Application.Factory.Oferta;

import org.example.inventario.Domain.Models.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
}
