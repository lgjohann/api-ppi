package com.arduinoppi.apippi.repository;

import com.arduinoppi.apippi.domain.DadosSensoriais;
import com.arduinoppi.apippi.web.dto.PesquisaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DadosSensoriaisRepository extends JpaRepository<DadosSensoriais, Long> {

    @Query("SELECT d FROM DadosSensoriais d WHERE d.dataHora BETWEEN :startTime AND :endTime")
    List<DadosSensoriais> findByRangeTime(
            @Param("startTime") LocalDateTime dataHoraInicial,
            @Param("endTime") LocalDateTime dataHoraFinal);

    List<DadosSensoriais> findBySensor(String sensor);

    @Query("SELECT d FROM DadosSensoriais d WHERE d.dataHora BETWEEN :startTime AND :endTime AND d.sensor = :sensor")
    List<DadosSensoriais> findByRangeTimeSensor(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime,
            @Param("sensor") String sensor);
}
