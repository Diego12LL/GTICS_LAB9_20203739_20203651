package com.example.lab9.Controller;

import com.example.lab9.Entity.Equipo;
import com.example.lab9.Repository.EquipoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/equipo")
public class EquipoController {
    final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @PostMapping( "/registro")
    public ResponseEntity<HashMap<String, Object>> registrarEquipo(
            @RequestBody Equipo equipo,   //para crear se usa body en postman - raw
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {  //pa que devuelva o no id: ...8080/product?fetchid=true

        HashMap<String, Object> responseJson = new HashMap<>();

        if (equipo.getNombreEquipo() == null || equipo.getNombreEquipo().isEmpty() ||
                equipo.getColorEquipo() == null || equipo.getColorEquipo().isEmpty() ||
                equipo.getMascota() == null || equipo.getMascota().isEmpty()) {
            responseJson.put("error", "Todos los campos son obligatorios.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseJson);
        }


        try {
            equipoRepository.save(equipo);
            if (fetchId) {
                responseJson.put("id", equipo.getIdEquipo());
            }
            responseJson.put("estado", "Equipo registrado");
            return ResponseEntity.status(HttpStatus.OK).body(responseJson);
        }catch (DataIntegrityViolationException e) {
            responseJson.put("estado", "Equipo NO registrado");
            responseJson.put("error", "Alguno de los parámetros ingresados ya existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseJson);
        }
    }
}
