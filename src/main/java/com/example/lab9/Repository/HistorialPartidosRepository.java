package com.example.lab9.Repository;

import com.example.lab9.Entity.Equipo;
import com.example.lab9.Entity.HistorialPartidos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialPartidosRepository extends JpaRepository<HistorialPartidos, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into historialpartidos (partido_idpartido,horaFecha) values (?1,current_timestamp());")
    void guardarEnHistorial(int idPartido);
}
