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

    @Query(nativeQuery = true,value = "select pp.idparticipantesPartido, pp.partido_idpartido, pp.participante_idparticipante, pp.horaFecha\n" +
            "from participantespartido pp\n" +
            "inner join participante p on (pp.participante_idparticipante = p.idparticipante)\n" +
            "inner join partido pa on (pp.partido_idpartido = pa.idpartido)\n" +
            "where pa.equipoA = ?1 or pa.equipoB = ?1;")
    List<HistorialPartidos> encontrarPartido(int idEquipo);

}
