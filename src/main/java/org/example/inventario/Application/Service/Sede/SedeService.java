package org.example.inventario.Application.Service.Sede;

import org.example.inventario.Application.Factory.Sede.SedeRepository;
import org.example.inventario.Domain.Models.Rol;
import org.example.inventario.Domain.Models.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> GetSedes(){
        return sedeRepository.findAll();
    }

    public boolean CreateSede(Sede newSede){
        Sede sedeExiste = sedeRepository.FindByName(newSede.getNombre());

        if(sedeExiste != null){
            return false;
        }

        sedeRepository.save(newSede);
        return true;
    }

    public Sede UpdateSede(Sede newSede , Long id){

        return sedeRepository.findById(id)
                .map(sede -> {

                    sede.setNombre(newSede.getNombre());
                    sede.setDireccion(newSede.getDireccion());
                    sede.setUsuarioModifica(newSede.getUsuarioModifica());
                    sede.setFechaModifica(newSede.getFechaModifica());

                    return sedeRepository.save(sede);
                })
                .orElse(null);
    }

    public Sede DeleteSede(Long id){
        Optional<Sede> sedeOptional = sedeRepository.findById(id);

        if (sedeOptional.isPresent()) {
            Sede sede = sedeOptional.get();
            sedeRepository.deleteById(id);
            return sede;
        } else {
            return null;
        }
    }
}
