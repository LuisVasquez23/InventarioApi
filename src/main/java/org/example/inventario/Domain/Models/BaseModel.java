package org.example.inventario.Domain.Models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel {
    @Column(name = "UsuarioCrea")
    private String UsuarioCrea;

    @Column(name = "FechaCrea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaCrea;

    @Column(name = "UsuarioModifica")
    private String UsuarioModifica;

    @Column(name = "FechaModifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaModifica;

    @Column(name = "UsuarioBloquea")
    private String UsuarioBloquea;

    @Column(name = "FechaBloquea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaBloquea;
}
