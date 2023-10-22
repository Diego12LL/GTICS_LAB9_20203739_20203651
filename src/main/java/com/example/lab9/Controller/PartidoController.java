package com.example.lab9.Controller;

import com.example.lab9.Entity.Equipo;
import com.example.lab9.Entity.Participante;
import com.example.lab9.Entity.ParticipantesPartido;
import com.example.lab9.Entity.Partido;
import com.example.lab9.Repository.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/partido")    //PARA QUE QUE DE ESTA PARTE SE MODIFICÓ LA DB, DEPORTE AHORA ESTÁ EN PARTIDO Y YA NO EN HISTORIALPARTIDOS
public class PartidoController {    //SOLO CAMBIAN ENTIDADES TODO TRANQUI ;v/
    final PartidoRepository partidoRepository;
    final HistorialPartidosRepository historialPartidosRepository;

    final ParticipantesPartidoRepository participantesPartidoRepository;
    public PartidoController(PartidoRepository partidoRepository, HistorialPartidosRepository historialPartidosRepository, ParticipantesPartidoRepository participantesPartidoRepository) {
        this.partidoRepository = partidoRepository;
        this.historialPartidosRepository = historialPartidosRepository;
        this.participantesPartidoRepository = participantesPartidoRepository;
    }
    @PostMapping( "/registro")
    public ResponseEntity<HashMap<String, Object>> registrarPartido(
            @RequestBody Partido partido,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {  //pa que devuelva o no id: ...8080/product?fetchid=true

        HashMap<String, Object> responseJson = new HashMap<>();


        if (partido.getEquipoA() == null || partido.getEquipoB() == null ||
                partido.getScoreA() == null || partido.getScoreB() == null ||
                partido.getDeporte() == null) {
            responseJson.put("error", "Todos los campos son obligatorios.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseJson);
        }

        partidoRepository.save(partido);
        historialPartidosRepository.guardarEnHistorial(partido.getIdPartido());


        if (fetchId) {
            responseJson.put("id", partido.getIdPartido());
        }
        responseJson.put("estado", "Partido registrado y añadido a historial");

        return ResponseEntity.status(HttpStatus.OK).body(responseJson);



    }
    @GetMapping(value="/getparticipantes")
    public List<ParticipantesPartido> listarParticipantesXPartido(){
        return participantesPartidoRepository.findAll();
    }
}
