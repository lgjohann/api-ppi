package com.arduinoppi.apippi.repository;

import com.arduinoppi.apippi.domain.DadosSensoriais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DadosSensoriaisRepository extends JpaRepository<DadosSensoriais, Long> {

    @Query("SELECT d FROM DadosSensoriais d WHERE d.dataHora BETWEEN :startTime AND :endTime")
    List<DadosSensoriais> findByRangeTime(@Param("startTime") LocalDateTime dataHoraInicial, @Param("endTime") LocalDateTime dataHoraFinal);

    List<DadosSensoriais> findBySensor(String sensor);
}
