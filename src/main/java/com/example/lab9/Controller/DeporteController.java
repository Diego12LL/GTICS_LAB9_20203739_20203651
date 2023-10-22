package com.example.lab9.Controller;

import com.example.lab9.Entity.Deporte;
import com.example.lab9.Entity.Equipo;
import com.example.lab9.Repository.DeporteRepository;
import com.example.lab9.Repository.EquipoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/deporte")
public class DeporteController {
    final DeporteRepository deporteRepository;

    public DeporteController(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @PostMapping( "/registro")
    public ResponseEntity<HashMap<String, Object>> registrarDeporte(
            @RequestBody Deporte deporte,   //para crear se usa body en postman - raw
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {  //pa que devuelva o no id: ...8080/product?fetchid=true

        HashMap<String, Object> responseJson = new HashMap<>();

        if (deporte.getNombreDeporte() == null || deporte.getNombreDeporte().isEmpty() ||
                deporte.getPesoDeporte() == null) {
            responseJson.put("error", "Todos los campos son obligatorios.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseJson);
        }

    
        try {
            deporteRepository.save(deporte);
            if (fetchId) {
                responseJson.put("id", deporte.getIdDeporte());
            }
            responseJson.put("estado", "Deporte registrado");
            return ResponseEntity.status(HttpStatus.OK).body(responseJson);
        }catch (DataIntegrityViolationException e) {
            responseJson.put("estado", "Deporte NO registrado");
            responseJson.put("error", "El nombre del deporte ya existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseJson);
        }
    }
}
