package com.example.lab9.Controller;

import com.example.lab9.Entity.Equipo;
import com.example.lab9.Entity.Participante;
import com.example.lab9.Repository.EquipoRepository;
import com.example.lab9.Repository.ParticipanteRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {
    final ParticipanteRepository participanteRepository;

    public ParticipanteController(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }
    @PostMapping( "/registro")
    public ResponseEntity<HashMap<String, Object>> registrarParticipante(
            @RequestBody Participante participante,   //para crear se usa body en postman - raw
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {  //pa que devuelva o no id: ...8080/product?fetchid=true

        HashMap<String, Object> responseJson = new HashMap<>();

        if (participante.getCarrera() == null || participante.getCarrera().isEmpty() ||
                participante.getCodigo() == null ||
                participante.getTipoParticipante() == null || participante.getTipoParticipante().isEmpty() ||
                participante.getEquipo() == null) {
            responseJson.put("error", "Todos los campos son obligatorios.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseJson);
        }

        participanteRepository.save(participante);
        if (fetchId) {
            responseJson.put("id", participante.getIdparticipante());
        }
        responseJson.put("estado", "Participante registrado");
        return ResponseEntity.status(HttpStatus.OK).body(responseJson);

    }
}
