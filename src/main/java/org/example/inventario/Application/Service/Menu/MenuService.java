package org.example.inventario.Application.Service.Menu;

import org.example.inventario.Application.Factory.Menu.MenuRepository;
import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.Menu;
import org.example.inventario.Domain.Models.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> GetMenus(){
        return menuRepository.findAll();
    }

    public boolean CreateMenu(Menu newMenu){
        Menu menuExiste = menuRepository.findByName(newMenu.getNombre());

        if(menuExiste != null){
            return false;
        }

        menuRepository.save(newMenu);
        return true;
    }
    public Menu UpdateMenu(Menu newMenu , Long id){

        return menuRepository.findById(id)
                .map(menu -> {

                    menu.setNombre(newMenu.getNombre());
                    menu.setUrl(newMenu.getUrl());
                    menu.setOrden(newMenu.getOrden());
                    menu.setMenuPadre(newMenu.getMenuPadre());
                    menu.setUsuarioModifica(newMenu.getUsuarioModifica());
                    menu.setFechaModifica(newMenu.getFechaModifica());

                    return menuRepository.save(menu);
                })
                .orElse(null);
    }
    public Menu DeleteMenu(Long id){
        Optional<Menu> menuOptional = menuRepository.findById(id);

        if (menuOptional.isPresent()) {
            Menu menu = menuOptional.get();
            menuRepository.deleteById(id);
            return menu;
        } else {
            return null;
        }
    }


}
