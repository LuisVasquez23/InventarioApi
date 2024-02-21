package org.example.inventario.Domain.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Menu extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMenu")
    private int IdMenu;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Url")
    private String Url;

    @Column(name = "Orden")
    private String Orden;

    @ManyToOne
    @JoinColumn(name = "IdMenuPadre", referencedColumnName = "IdMenu")
    private Menu MenuPadre;



}
