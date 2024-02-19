package org.example.inventario.Application.Service.LogTipoEvento;

import org.example.inventario.Application.Factory.LogTipoEventos.LogTipoEventoRepository;
import org.example.inventario.Domain.Models.LogTipoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class LogTipoEventoService {
    @Autowired
    private LogTipoEventoRepository logTipoEventoRepository;

    public List<LogTipoEvento> GetLogTipoEventos() {return logTipoEventoRepository.findAll();}

    public  boolean CreateLogTipoEvento(LogTipoEvento newLogTipoEvento){
        LogTipoEvento logTipoEventoExist = logTipoEventoRepository.findByTipo(newLogTipoEvento.getTipo());
        if(logTipoEventoExist !=null){
            return false;
        }
        logTipoEventoRepository.save(newLogTipoEvento);
        return true;
    }

    public  LogTipoEvento UpdateLogTipoEvento(LogTipoEvento newLogTipoEvento,Long id){
        return logTipoEventoRepository.findById(id)
                .map(LogTipoEvento ->{
                    LogTipoEvento.setTipo(newLogTipoEvento.getTipo());
                    LogTipoEvento.setFechaModifica(newLogTipoEvento.getFechaModifica());
                    LogTipoEvento.setUsuarioModifica(newLogTipoEvento.getUsuarioModifica());
                    return logTipoEventoRepository.save(LogTipoEvento);
                })
                .orElse(null);
    }

    public LogTipoEvento DeleteLogTipoEvento(Long id){
        Optional<LogTipoEvento> optionalLogTipoEvento = logTipoEventoRepository.findById(id);
        if(optionalLogTipoEvento.isPresent()){
            LogTipoEvento DeltedLogTipoEvento = optionalLogTipoEvento.get();
            logTipoEventoRepository.deleteById(id);
            return DeltedLogTipoEvento;
        }else{
            return  null;
        }
    }
}
