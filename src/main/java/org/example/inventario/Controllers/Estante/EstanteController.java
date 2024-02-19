package org.example.inventario.Controllers.Estante;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.Estante.EstanteService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Estante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Estante")

public class EstanteController {
    @Autowired
    private EstanteService estanteService;

    @GetMapping
    public BaseResponseModel Get(){
        List<Estante> estantes = estanteService.GetEstantes();
        if(estantes !=null){
            return ResponseApiService.response(200,estantes,"Succes");
        }
        return ResponseApiService.response(500,estantes,"Erro with data");
    }

    @PostMapping
    public BaseResponseModel Create(@RequestBody Estante estante){
        if(estante.getNombre()== null){
            return  ResponseApiService.response(500, estante,"Nombre is required");
        }
        boolean added = estanteService.CreateEstante(estante);

        if(added){
            return  ResponseApiService.response(200,estante,"Estante created successfully");
        }
        return  ResponseApiService.response(500,estante,"Estante is already created");
    }

    @PutMapping
    public  BaseResponseModel Update(@RequestBody Estante estante, Long id){
        if(id==null){
            return  ResponseApiService.response(500,estante,"Id is required");
        }
        Estante estanteUpdate = estanteService.UpdateEstante(estante,id);

        if(estanteUpdate != null){
            return ResponseApiService.response(200,estante,"Estantante is already updated");
        }
        return ResponseApiService.response(404,estante,"Estante not found");
    }
    @DeleteMapping
    public  BaseResponseModel Delete(Long id){
        if(id == null){
            return  ResponseApiService.response(500,null,"Id is required");
        }
        Estante estanteDelete = estanteService.DeleteEstante(id);

        if(estanteDelete !=null){
            return ResponseApiService.response(200,estanteDelete,"Estatente deleted successfully");
        }
        return ResponseApiService.response(404,null, "Estante not found");

    }
}
