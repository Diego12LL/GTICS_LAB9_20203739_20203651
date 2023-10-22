package com.example.lab9.Repository;

import com.example.lab9.Entity.Equipo;
import com.example.lab9.Entity.HistorialPartidos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialPartidosRepository extends JpaRepository<HistorialPartidos, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into historialpartidos (partido_idpartido,horaFecha) values (?1,current_timestamp());")
    void guardarEnHistorial(int idPartido);

    @Query(nativeQuery = true,value = "SELECT * FROM historialpartidos hp \n" +
            "inner join partido p on hp.partido_idpartido = p.idpartido\n" +
            "where equipoA = ?1 or equipoB = ?1 ;")
    List<HistorialPartidos> encontrarPartido(int idEquipo);

}
