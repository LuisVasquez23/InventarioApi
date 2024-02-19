package org.example.inventario.Controllers.Rol;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.Rol.RolService;
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
        List<Rol> roles = rolService.GetRoles();
        return ResponseApiService.response(200, roles, "Success" );
    }

    @PostMapping
    public BaseResponseModel Create(@RequestBody Rol rol){

        if(rol.getRol() == null){
            return ResponseApiService.response(500 , rol , "Rol is required");
        }

        boolean added = rolService.CreateRol(rol);

        if(added){
            return ResponseApiService.response(200 , rol , "Rol created successfully");
        }

        return ResponseApiService.response(500 , rol , "Rol is already created");

    }

    @PutMapping("/{id}")
    public BaseResponseModel Update(@RequestBody Rol rol, @PathVariable Long id){

        if(id == null){
            return ResponseApiService.response(500 , rol , "Id is required");
        }

        Rol rolUpdated = rolService.UpdateRol(rol , id);

        if(rolUpdated != null){
            return ResponseApiService.response(200 , rol , "Rol updated successfully");
        }

        return ResponseApiService.response(404, rol , "Rol is not found");
    }

    @DeleteMapping("/{id}")
    public BaseResponseModel Delete(@PathVariable Long id){

        if(id == null){
            return ResponseApiService.response(500 , null , "Id is required");
        }

        Rol rolDeleted = rolService.DeleteRol(id);

        if(rolDeleted != null){
            return ResponseApiService.response(200 , rolDeleted , "Rol deleted successfully");
        }

        return ResponseApiService.response(404, null , "Rol is not found");
    }
}
