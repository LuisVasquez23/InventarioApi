package org.example.inventario.Application.Service.UnidadMedida;

import org.example.inventario.Application.Factory.UnidadesMedidas.UnidadMedidaRepository;
import org.example.inventario.Domain.Models.Sede;
import org.example.inventario.Domain.Models.UnidadMedidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public List<UnidadMedidas> GetAll(){
        return unidadMedidaRepository.findAll();
    }

    public UnidadMedidas Create(UnidadMedidas unidad){
        try {
            return unidadMedidaRepository.save(unidad);
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }



}
