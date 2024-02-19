package org.example.inventario.Domain.Models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel {
    private String UsuarioCrea;
    private Date FechaCrea;
    private String UsuarioModifica;
    private Date FechaModifica;
    private String UsuarioBloquea;
    private Date FechaBloquea;
}
