package org.example.inventario.Controllers.Categoria;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.Categoria.CategoriaService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Categoria")

public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public BaseResponseModel Get(){
        List<Categoria> categorias = categoriaService.GetCategorias();
        return ResponseApiService.response(200, categorias , "Success" );

    }

    @PostMapping
    public BaseResponseModel Create(@RequestBody Categoria categoria){
        if(categoria.getCategoria() == null){
            return ResponseApiService.response(500 , categoria , "categoria is required");
        }
        boolean added = categoriaService.CreateCategoria(categoria);

        if(added){
            return ResponseApiService.response(200 , categoria , "categoria created successfully");
        }
        return ResponseApiService.response(500 , categoria , "categoria is already created");

    }

    @PutMapping
    public  BaseResponseModel Update(@RequestBody Categoria categoria, Long id){
        if(id == null){
            return ResponseApiService.response(500, categoria, "Id is required");
        }
        Categoria categoriaUpdated = categoriaService.UpdateCategoria(categoria, id);

        if(categoriaUpdated != null){
            return ResponseApiService.response(200, categoria, "Categoria updated successfully");
        }
        return ResponseApiService.response(404, categoria, "Categoria is not found");
    }

    @DeleteMapping
    public BaseResponseModel Delete(Long id){
        if(id == null){
            return ResponseApiService.response(500, null, "Id is required");
        }
        Categoria categoriaDeleted = categoriaService.DeleteCategoria(id);
        if(categoriaDeleted != null){
            return ResponseApiService.response(200,categoriaDeleted, "Categoria deleted successfully");
        }
        return ResponseApiService.response(404,null,"Categoria is not found");
    }
}
