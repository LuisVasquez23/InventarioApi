package org.example.inventario.Controllers.VariableSistema;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.VariableSistema.VariableSistemaService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Sede;
import org.example.inventario.Domain.Models.VariableSistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/VariableSistema")
public class VariableSistemaController {

    @Autowired
    private VariableSistemaService variableSistemaService;

    @GetMapping()
    public BaseResponseModel GetAll(){
        List<VariableSistema> variables = variableSistemaService.GetAll();
        return ResponseApiService.response(200, variables, "Success" );
    }

    @PostMapping()
    public BaseResponseModel Create(@RequestBody VariableSistema variable){

        if(variable.getNombreVariable() == null){
            return ResponseApiService.response(500 , variable , "Nombre is required");
        }

        VariableSistema added = variableSistemaService.Create(variable);

        if(added != null){
            return ResponseApiService.response(200 , added , "Sede created successfully");
        }

        return ResponseApiService.response(500 , added , "Sede is already created");
    }

}
