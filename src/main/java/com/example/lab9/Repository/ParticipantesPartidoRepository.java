package com.example.lab9.Repository;

import com.example.lab9.Entity.HistorialPartidos;
import com.example.lab9.Entity.ParticipantesPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantesPartidoRepository extends JpaRepository<ParticipantesPartido, Integer> {

    @Query(nativeQuery = true , value = "select pp.idparticipantesPartido, pp.partido_idpartido, pp.participante_idparticipante, pp.horaFecha\n" +
            "from participantespartido pp\n" +
            "inner join participante p on (pp.participante_idparticipante = p.idparticipante)\n" +
            "inner join partido pa on (pp.partido_idpartido = pa.idpartido)\n" +
            "inner join equipo ea on (pa.equipoA = ea.idequipo)\n" +
            "inner join equipo eb on (pa.equipoB = eb.idequipo)\n" +
            "where pa.equipoA = ?1 or pa.equipoB = ?1; ")
    List<ParticipantesPartido> participantesXPartido(int idEquipo);
}
