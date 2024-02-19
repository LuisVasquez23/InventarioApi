package org.example.inventario.Controllers.LogTipoEvento;

import org.example.inventario.Application.Factory.ResponseApiService;
import org.example.inventario.Application.Service.LogTipoEvento.LogTipoEventoService;
import org.example.inventario.Domain.BaseResponseModel;
import org.example.inventario.Domain.Models.LogTipoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logTipoEvento")

public class LogTipoEventoController {
    @Autowired
    private LogTipoEventoService logTipoEventoService;

    @GetMapping
    public BaseResponseModel Get(){
        List<LogTipoEvento> eventos = logTipoEventoService.GetLogTipoEventos();
        return ResponseApiService.response(200,eventos,"Successs");
    }

    @PostMapping
    public BaseResponseModel Create(@RequestBody LogTipoEvento logTipoEvento){
        if(logTipoEvento.getTipo() ==null){
            return ResponseApiService.response(500,logTipoEvento,"Tipo is required");
        }
        boolean added = logTipoEventoService.CreateLogTipoEvento(logTipoEvento);

        if(added){
            return  ResponseApiService.response(200,logTipoEvento,"logTipoEvento is created successfully");
        }
        return ResponseApiService.response(500,logTipoEvento,"logTipoEvento is already created");
    }
    @PutMapping
    public BaseResponseModel Update(@RequestBody LogTipoEvento logTipoEvento,Long id){
        if(id == null){
            return ResponseApiService.response(500 , logTipoEvento , "Id is required");
        }

        LogTipoEvento logTipoEventoUpdated = logTipoEventoService.UpdateLogTipoEvento(logTipoEvento,id);

        if(logTipoEventoUpdated != null){
            return ResponseApiService.response(200 , logTipoEventoUpdated , "logTipoEventoUpdated updated successfully");
        }

        return ResponseApiService.response(404, logTipoEventoUpdated , "logTipoEventoUpdated is not found");
    }

    @DeleteMapping
    public BaseResponseModel Delete(Long id){
        if(id == null){
            return ResponseApiService.response(500 , null , "Id is required");
        }

        LogTipoEvento logTipoEventoDelted = logTipoEventoService.DeleteLogTipoEvento(id);

        if(logTipoEventoDelted != null){
            return ResponseApiService.response(200 , logTipoEventoDelted , "LogTipoEvento deleted successfully");
        }

        return ResponseApiService.response(404, null , "LogTipoEvento is not found");
    }
}
