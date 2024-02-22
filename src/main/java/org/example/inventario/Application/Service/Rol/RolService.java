package org.example.inventario.Application.Service.Rol;

import org.example.inventario.Application.Factory.Rol.RolRepository;
import org.example.inventario.Domain.Models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> GetRoles(){
        return rolRepository.findAll();
    }

    public  boolean CreateRol(Rol newRol){

        Rol rolExist = rolRepository.FindByRol(newRol.getRol());

        if(rolExist != null){
            return  false;
        }

        rolRepository.save(newRol);
        return true;

    }

    public Rol UpdateRol(Rol newRol, Long id) {

        Optional<Rol> rolOptional = rolRepository.findById(id);

        if (rolOptional.isPresent()) {

            Rol rol = rolOptional.get();
            rol.setRol(newRol.getRol());

            return rolRepository.save(rol);
        } else {
            return null;
        }
    }

    public Rol DeleteRol(Long id){
        Optional<Rol> rolOptional = rolRepository.findById(id);

        if (rolOptional.isPresent()) {
            Rol rol = rolOptional.get();
            rolRepository.deleteById(id);
            return rol;
        } else {
            return null;
        }
    }

}
