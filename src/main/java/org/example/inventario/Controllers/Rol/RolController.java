package org.example.inventario.Controllers.Rol;

import org.example.inventario.Application.Services.Rol.RolService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public BaseResponseModel Get() {
        List<Rol> personas = rolService.findAll();
        return new BaseResponseModel(200, true, "Success", personas);
    }

    @PostMapping
    public BaseResponseModel createPersona(@RequestBody Rol rol) {
        Rol newRol = rolService.save(rol);
        return new BaseResponseModel(201, true, "Rol created successfully", newRol);
    }
}
