package com.example.lab9.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "participante")
@Getter
@Setter
//@JsonIgnoreProperties(value = {"picture"}) //En la entidad se ignora para el Json
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparticipante", nullable = false)
    private Integer idparticipante;

    @ManyToOne
    @JoinColumn(name = "equipo")
    private Equipo equipo;

    @Column(name = "carrera", length = 45)
    private String carrera;

    @Column(name = "codigo")
    private BigDecimal codigo;

    @Column(name = "tipoParticipante", length = 45)
    private String tipoParticipante;



}