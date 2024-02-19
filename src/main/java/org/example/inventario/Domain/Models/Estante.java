package org.example.inventario.Domain.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estante extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEstante")
    private int IdEstante;

    private String Nombre;
    private String Direccion;

}
