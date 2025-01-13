package com.arduinoppi.apippi.web.controller;

import com.arduinoppi.apippi.domain.Sensor;
import com.arduinoppi.apippi.service.SensorService;
import com.arduinoppi.apippi.web.dto.SensorCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    public ResponseEntity<Sensor> save(@RequestBody SensorCreateDTO sensor) {
        Sensor saved_sensor = sensorService.save(sensor);
        return ResponseEntity.ok(saved_sensor);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Sensor> findByName(@PathVariable String name) {
        Sensor sensor = sensorService.findByName(name);
        return ResponseEntity.ok(sensor);
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> findAll() {
        List<Sensor> sensors = sensorService.findAll();
        return ResponseEntity.ok(sensors);
    }

    @PutMapping(value = "/{name}")
    public ResponseEntity<Sensor> update(@RequestBody SensorCreateDTO dto) {
        Sensor sensor = sensorService.updateSensor(dto);
        return ResponseEntity.ok(sensor);
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<Sensor> delete(@PathVariable String name) {
        sensorService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
