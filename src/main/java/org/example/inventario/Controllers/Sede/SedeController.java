package org.example.inventario.Controllers.Sede;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.Sede.SedeService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Rol;
import org.example.inventario.Domain.Models.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Sede")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping
    public BaseResponseModel Get() {
        List<Sede> sedes = sedeService.GetSedes();
        return ResponseApiService.response(200, sedes, "Success" );
    }

    @PostMapping
    public BaseResponseModel Create(@RequestBody Sede sede){

        if(sede.getNombre() == null){
            return ResponseApiService.response(500 , sede , "Nombre is required");
        }

        boolean added = sedeService.CreateSede(sede);

        if(added){
            return ResponseApiService.response(200 , sede , "Sede created successfully");
        }

        return ResponseApiService.response(500 , sede , "Sede is already created");
    }

    @PutMapping
    public BaseResponseModel Update(@RequestBody Sede sede, Long id){

        if(id == null){
            return ResponseApiService.response(500 , sede , "Id is required");
        }

        Sede sedeUpdated = sedeService.UpdateSede(sede , id);

        if(sedeUpdated != null){
            return ResponseApiService.response(200 , sede , "Sede updated successfully");
        }

        return ResponseApiService.response(404, sede , "Sede is not found");
    }

    @DeleteMapping
    public  BaseResponseModel Delete(Long id){
        if(id == null){
            return ResponseApiService.response(500 , null , "Id is required");
        }

        Sede sedeDeleted = sedeService.DeleteSede(id);

        if(sedeDeleted != null){
            return ResponseApiService.response(200 , sedeDeleted , "Sede deleted successfully");
        }

        return ResponseApiService.response(404, null , "Sede is not found");
    }
}
