package org.example.inventario.Application.Service.VariableSistema;

import org.example.inventario.Application.Factory.VariableSistema.VariableSistemaRepository;
import org.example.inventario.Domain.Models.Sede;
import org.example.inventario.Domain.Models.VariableSistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariableSistemaService {

    @Autowired
    private VariableSistemaRepository variableSistemaRepository;

    public List<VariableSistema> GetAll(){
        return  variableSistemaRepository.findAll();
    }

    public VariableSistema Create(VariableSistema newVariable){
        return variableSistemaRepository.save(newVariable);
    }

    public VariableSistema Update(VariableSistema newVariable , Long Id){
        return variableSistemaRepository.findById(Id)
                .map(variable -> {

                    variable.setNombreVariable(newVariable.getNombreVariable());
                    variable.setValor(newVariable.getValor());

                    return variableSistemaRepository.save(variable);
                })
                .orElse(null);
    }

    public VariableSistema Delete(Long id){
        Optional<VariableSistema> variableSistema = variableSistemaRepository.findById(id);

        if (variableSistema.isPresent()) {
            VariableSistema variable = variableSistema.get();
            variableSistemaRepository.deleteById(id);
            return variable;
        } else {
            return null;
        }
    }

}
