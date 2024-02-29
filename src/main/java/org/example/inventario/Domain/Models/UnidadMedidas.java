package org.example.inventario.Domain.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UnidadMedidas extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUnidadMedida;

    @Column(unique = true)
    private String Nombre;
    private String Descripcion;



}
