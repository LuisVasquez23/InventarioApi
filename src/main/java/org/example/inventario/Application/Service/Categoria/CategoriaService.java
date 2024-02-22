package org.example.inventario.Application.Service.Categoria;

import org.example.inventario.Application.Factory.Categoria.CategoriaRepository;
import org.example.inventario.Domain.Models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> GetCategorias(){
        return categoriaRepository.findAll();
    }

    public boolean CreateCategoria(Categoria newCategoria){
        Categoria categoriaExist = categoriaRepository.findByCategoria(newCategoria.getCategoria());

        if(categoriaExist != null){
            return  false;
        }
        categoriaRepository.save(newCategoria);
        return true;

    }

    public Categoria UpdateCategoria(Categoria newCategoria, long id ){
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setDescripcion(newCategoria.getDescripcion());
                    categoria.setCategoria(newCategoria.getCategoria());
                    categoria.setUsuarioModifica(newCategoria.getUsuarioModifica());
                    categoria.setFechaModifica(newCategoria.getFechaModifica());

                    return categoriaRepository.save(categoria);


                })
                .orElse(null);
    }

    public Categoria DeleteCategoria(long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if(categoriaOptional.isPresent()){
            Categoria categoria = categoriaOptional.get();
            categoriaRepository.deleteById(id);
            return categoria;
        }else{
            return null;
        }

    }



}
