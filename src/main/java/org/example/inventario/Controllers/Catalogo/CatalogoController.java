package org.example.inventario.Controllers.Catalogo;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.Catalogo.CatalogoService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Catalogo;
import org.example.inventario.Domain.Models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BandedSampleModel;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @GetMapping
    public BaseResponseModel Get(){
        List<Catalogo> catalogos = catalogoService.GetCatalogos();
        return ResponseApiService.response(200,catalogos,"Success");
    }

    @PostMapping
    public BaseResponseModel Create(@RequestBody Catalogo catalgo){
        if(catalgo.getNombre()==null){
            return  ResponseApiService.response(500,catalgo,"Nombre is required");
        }
        boolean added = catalogoService.CreateCatalogo(catalgo);
        if(added){
            return ResponseApiService.response(200,catalgo,"Created added success");
        }
        return ResponseApiService.response(500,catalgo,"Catalog is already created");

    }
    @PutMapping
    public BaseResponseModel Update(@RequestBody Catalogo catalogo,Long id){
        if(id == null ){
            return  ResponseApiService.response(500,catalogo,"Id is required");
        }
        Catalogo catalogoUpdate = catalogoService.UpdateCatalogo(catalogo,id);
        if(catalogoUpdate != null){
            return ResponseApiService.response(200,catalogo,"Catalogo update successfuly");
        }
        return ResponseApiService.response(404,catalogo,"Catalogo is not found");
    }
    @DeleteMapping
    public  BaseResponseModel Delete(Long id){
        if(id == null){
            ResponseApiService.response(500,null,"ID is required");
        }

        Catalogo catalogoDeleted = catalogoService.DeleteCatalogo(id);
        if(catalogoDeleted !=null){
            return ResponseApiService.response(200,catalogoDeleted,"Catalogo deleted successfuly");
        }
        return  ResponseApiService.response(404,null,"Catalogo is not found");
    }

}
