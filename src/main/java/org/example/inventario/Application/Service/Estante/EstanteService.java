package org.example.inventario.Application.Service.Estante;

import jakarta.persistence.Entity;
import org.example.inventario.Application.Factory.Estante.EstanteRepository;
import org.example.inventario.Domain.Models.Estante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EstanteService {
    @Autowired
    private EstanteRepository estanteRepository;

    public List<Estante> GetEstantes() { return  estanteRepository.findAll();}

    public boolean CreateEstante(Estante estante){
        Estante estanteExists = estanteRepository.findByName(estante.getNombre());

        if(estanteExists != null){
            return false;
        }
        estanteRepository.save(estante);
        return true;
    }

    public Estante UpdateEstante(Estante newEstante, Long id){
        return estanteRepository.findById(id)
                .map(estante ->{
                    estante.setNombre(newEstante.getNombre());
                    estante.setDireccion(newEstante.getDireccion());
                    estante.setFechaModifica(newEstante.getFechaModifica());
                    estante.setUsuarioModifica(newEstante.getUsuarioModifica());
                    return estanteRepository.save(estante);
                })
                .orElse( null);
    }
    public Estante DeleteEstante(Long id){
        Optional<Estante> optionalEstante = estanteRepository.findById(id);

        if(optionalEstante.isPresent()){
            Estante estante = optionalEstante.get();
            estanteRepository.deleteById(id);
            return estante;
        }else{
            return null;
        }
    }
}
