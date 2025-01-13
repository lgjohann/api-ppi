package com.arduinoppi.apippi.service;

import com.arduinoppi.apippi.domain.Sensor;
import com.arduinoppi.apippi.repository.SensorRepository;
import com.arduinoppi.apippi.web.dto.SensorUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    @Transactional
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Transactional(readOnly = true)
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Sensor findByName(String name) {
        return sensorRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("Sensor not found")
        );
    }

    @Transactional
    public Sensor updateSensor(SensorUpdateDTO dto) {
        Sensor sensor = findByName(dto.getName());
        sensor.setNome(dto.getName());
        sensor.setValorConfig(dto.getValorConfig());
        return sensorRepository.save(sensor);
    }

    public void delete(String name) {
        Sensor sensor = sensorRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("Sensor not found")
        );
        if (sensor != null) {
            sensorRepository.delete(sensor);
        }
    }
}
