package org.example.inventario.Controllers.Menu;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.Menu.MenuService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Menu;
import org.example.inventario.Domain.Models.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public BaseResponseModel Get() {
        List<Menu> menus = menuService.GetMenus();
        return ResponseApiService.response(200, menus, "Success" );
    }
    @PostMapping
    public BaseResponseModel Create(@RequestBody Menu menu){

        if(menu.getNombre() == null){
            return ResponseApiService.response(500 , menu , "Menu is required");
        }

        boolean added = menuService.CreateMenu(menu);

        if(added){
            return ResponseApiService.response(200 , menu , "Menu created successfully");
        }

        return ResponseApiService.response(500 , menu , "Menu is already created");
    }
    @PutMapping
    public BaseResponseModel Update(@RequestBody Menu menu, Long id){

        if(id == null){
            return ResponseApiService.response(500 , menu , "Id is required");
        }

        Menu menuUpdated = menuService.UpdateMenu(menu,id);

        if(menuUpdated != null){
            return ResponseApiService.response(200 , menu , "Menu updated successfully");
        }

        return ResponseApiService.response(404, menu , "Menu is not found");
    }
    @DeleteMapping
    public  BaseResponseModel Delete(Long id){
        if(id == null){
            return ResponseApiService.response(500 , null , "Id is required");
        }

        Menu menuDeleted = menuService.DeleteMenu(id);

        if(menuDeleted != null){
            return ResponseApiService.response(200 , menuDeleted , "Menu deleted successfully");
        }

        return ResponseApiService.response(404, null , "Menu is not found");
    }
}
