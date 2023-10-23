package com.example.lab9.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "partido")
@Getter
@Setter
//@JsonIgnoreProperties(value = {"picture"}) //En la entidad se ignora para el Json
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpartido", nullable = false)
    private Integer idPartido;

    @ManyToOne
    @JoinColumn(name = "equipoA")
    private Equipo equipoA;

    @ManyToOne
    @JoinColumn(name = "equipoB")
    private Equipo equipoB;

    @Column(name = "scoreA")
    private Integer scoreA;

    @Column(name = "scoreB")
    private Integer scoreB;

    @ManyToOne
    @JoinColumn(name = "deporte_iddeporte")
    private Deporte deporte;
}