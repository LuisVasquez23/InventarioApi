package org.example.inventario.Application.Service.Catalogo;

import org.example.inventario.Application.Factory.Catalogo.CatalogoRepository;
import org.example.inventario.Domain.Models.Catalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;

    public List<Catalogo> GetCatalogos(){return catalogoRepository.findAll();}

    public boolean CreateCatalogo(Catalogo newcatalogo){
        Catalogo categoriaExist = catalogoRepository.FindByName(newcatalogo.getNombre());
        if(categoriaExist != null){
            return false;
        }
        catalogoRepository.save(newcatalogo);
        return  true;
    }

    public Catalogo UpdateCatalogo(Catalogo newCatalogo, long id){
        return catalogoRepository.findById(id)
                .map(catalogo ->{
                    catalogo.setNombre(newCatalogo.getNombre());
                    catalogo.setValor(newCatalogo.getValor());
                    catalogo.setDescripcion(newCatalogo.getDescripcion());
                    catalogo.setUsuarioModifica(newCatalogo.getUsuarioModifica());
                    catalogo.setFechaModifica(newCatalogo.getFechaModifica());
                    return catalogoRepository.save(catalogo);
                })
                .orElse(null);
    }

    public Catalogo DeleteCatalogo(Long id){
        Optional<Catalogo> optionalCatalogo = catalogoRepository.findById(id);

        if(optionalCatalogo.isPresent()){
            Catalogo catalogo = optionalCatalogo.get();
            catalogoRepository.deleteById(id);
            return  catalogo;
        }else{
            return null;
        }
    }
}
