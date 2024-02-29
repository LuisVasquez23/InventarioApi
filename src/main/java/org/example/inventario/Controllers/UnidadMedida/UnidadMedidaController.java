package org.example.inventario.Controllers.UnidadMedida;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.UnidadMedida.UnidadMedidaService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.UnidadMedidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/UnidadMedida")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @GetMapping()
    public BaseResponseModel GetAll(){
        List<UnidadMedidas> unidadMedidas = unidadMedidaService.GetAll();

        return  ResponseApiService.response(200, unidadMedidas, "Success" );
    }

    @PostMapping()
    public BaseResponseModel Create(UnidadMedidas newUnidad){
        try{
            unidadMedidaService.Create(newUnidad);
            return  ResponseApiService.response(200, newUnidad, "Success" );
        }catch (Exception error){
            return  ResponseApiService.response(500, null , "Error" );
        }
    }

}
