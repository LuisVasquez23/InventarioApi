package org.example.inventario.Application.Service.UnidadMedida;

import org.example.inventario.Application.Factory.UnidadesMedidas.UnidadMedidaRepository;
import org.example.inventario.Domain.Models.Sede;
import org.example.inventario.Domain.Models.UnidadMedidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public List<UnidadMedidas> GetAll(){
        return unidadMedidaRepository.findAll();
    }

    public UnidadMedidas Create(UnidadMedidas unidadMedida){

        Optional<UnidadMedidas> unidadMedidaExistente = unidadMedidaRepository.GetMedidaByName(unidadMedida.getNombre());

        if(unidadMedidaExistente != null){
            return null;
        }

        return unidadMedidaRepository.save(unidadMedida);
    }

    public UnidadMedidas Update(UnidadMedidas newUnidad , Long id){
        return unidadMedidaRepository.findById(id)
                .map(unidadMedida -> {

                    unidadMedida.setNombre(newUnidad.getNombre());
                    unidadMedida.setDescripcion(newUnidad.getDescripcion());
                    unidadMedida.setUsuarioModifica(newUnidad.getUsuarioModifica());
                    unidadMedida.setFechaModifica(newUnidad.getFechaModifica());

                    return unidadMedidaRepository.save(unidadMedida);
                })
                .orElse(null);
    }

    public UnidadMedidas Delete(Long id){
        Optional<UnidadMedidas> unidadOptional = unidadMedidaRepository.findById(id);

        if (unidadOptional.isPresent()) {
            UnidadMedidas unidad = unidadOptional.get();
            unidadMedidaRepository.deleteById(id);
            return unidad;
        } else {
            return null;
        }
    }


}
