package com.arduinoppi.apippi.repository;

import com.arduinoppi.apippi.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findByName(String name);
}
