package com.example.lab9.Repository;

import com.example.lab9.Entity.HistorialPartidos;
import com.example.lab9.Entity.ParticipantesPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ParticipantesPartidoRepository extends JpaRepository<ParticipantesPartido, Integer>{

    @Query(nativeQuery = true , value = "select * from participantespartido pp\n" +
            "inner join participante p on (pp.participante_idparticipante = p.idparticipante)\n" +
            "inner join partido pa on (pp.partido_idpartido = pa.idpartido)\n" +
            "where pa.equipoA =:idEquipo or pa.equipoB =:idEquipo ")
    List<ParticipantesPartido> participantesXPartido(@Param("idEquipo") int idEquipo);

}
