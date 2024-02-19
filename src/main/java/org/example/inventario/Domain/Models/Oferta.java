package org.example.inventario.Domain.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdOferta")
    private int idOferta;

    @Column(name = "Porcentaje", precision = 10, scale = 2)
    private BigDecimal Porcentaje;

    @Column(name = "FechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaInicio;

    @Column(name = "FechaFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaFinal;

    @Column(name = "CodigoDescuento", length = 60)
    private String CodigoDescuento;

    @Column(name = "Estado", length = 1)
    private String Estado;

}
