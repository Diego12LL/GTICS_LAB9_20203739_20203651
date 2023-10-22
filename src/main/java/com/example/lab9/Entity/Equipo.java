package com.example.lab9.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipo")
@Getter
@Setter
//@JsonIgnoreProperties(value = {"picture"}) //En la entidad se ignora para el Json
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipo", nullable = false)
    private Integer idEquipo;

    @Column(name = "nombreEquipo", nullable = false, length = 45)
    private String nombreEquipo;

    @Column(name = "colorEquipo", length = 45)
    private String colorEquipo;

    @Column(name = "mascota",  length = 45)
    private String mascota;

}