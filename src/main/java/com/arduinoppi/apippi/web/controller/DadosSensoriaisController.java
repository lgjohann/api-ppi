package com.arduinoppi.apippi.web.controller;

import com.arduinoppi.apippi.domain.DadosSensoriais;
import com.arduinoppi.apippi.service.DadosSensoriaisService;
import com.arduinoppi.apippi.web.dto.DadosSensoriaisCreateDTO;
import com.arduinoppi.apippi.web.dto.PesquisaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leituras")
@RequiredArgsConstructor
public class DadosSensoriaisController {


    private final DadosSensoriaisService dadosSensoriaisService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DadosSensoriaisCreateDTO dadosSensoriais) {
        DadosSensoriais dados = DadosSensoriaisCreateDTO.toDados(dadosSensoriais);
        dadosSensoriaisService.create(dados);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/data_hora")
    public ResponseEntity<List<DadosSensoriais>> getByDataHora(@RequestBody PesquisaDTO pesquisaDTO) {
        List<DadosSensoriais> list = dadosSensoriaisService.findByDataHora(pesquisaDTO);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/nome_sensor")
    public ResponseEntity<List<DadosSensoriais>> getBySensor(@RequestBody PesquisaDTO pesquisaDTO) {
        List<DadosSensoriais> list = dadosSensoriaisService.findBySensor(pesquisaDTO);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/data_hora_sensor")
    public ResponseEntity<List<DadosSensoriais>> getByDataHoraSensor(@RequestBody PesquisaDTO pesquisaDTO) {
        List<DadosSensoriais> list = dadosSensoriaisService.findByDataHoraSensor(pesquisaDTO);
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<DadosSensoriais>> getAll() {
        List<DadosSensoriais> list = dadosSensoriaisService.findAll();
        return ResponseEntity.ok(list);
    }
}
