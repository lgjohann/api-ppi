package com.arduinoppi.apippi.web.controller;

import com.arduinoppi.apippi.domain.DadosSensoriais;
import com.arduinoppi.apippi.service.DadosSensoriaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/leituras")
@RequiredArgsConstructor
public class DadosSensoriaisController {


    private final DadosSensoriaisService dadosSensoriaisService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestParam DadosSensoriais dadosSensoriais) {
        dadosSensoriaisService.create(dadosSensoriais);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/data-hora")
    public ResponseEntity<List<DadosSensoriais>> getByDataHora(@RequestParam LocalDateTime dataHoraInicial, @RequestParam LocalDateTime dataHoraFinal) {
        List<DadosSensoriais> list = dadosSensoriaisService.findByDataHora(dataHoraInicial, dataHoraFinal);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/nome-sensor")
    public ResponseEntity<List<DadosSensoriais>> getBySensor(@RequestParam String sensor) {
        List<DadosSensoriais> list = dadosSensoriaisService.findBySensor(sensor);
        return ResponseEntity.ok(list);
    }
}
