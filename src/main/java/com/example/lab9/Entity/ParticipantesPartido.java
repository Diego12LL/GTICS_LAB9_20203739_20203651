package com.example.lab9.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "participantespartido")
@Getter
@Setter
//@JsonIgnoreProperties(value = {"picture"}) //En la entidad se ignora para el Json
public class ParticipantesPartido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparticipantesPartido", nullable = false)
    private Integer idParticipantesPartido;

    @ManyToOne
    @JoinColumn(name = "partido_idpartido")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "participante_idparticipante")
    private Participante participante;

    @Column(name = "horaFecha")
    private Date fechaHora;

}