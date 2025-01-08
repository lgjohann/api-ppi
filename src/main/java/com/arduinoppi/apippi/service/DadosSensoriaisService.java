package com.arduinoppi.apippi.service;

import com.arduinoppi.apippi.repository.DadosSensoriaisRepository;
import com.arduinoppi.apippi.domain.DadosSensoriais;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosSensoriaisService {

    private final DadosSensoriaisRepository dadosSensoriaisRepository;

    @Transactional
    public DadosSensoriais create(DadosSensoriais dadosSensoriais) {
        return dadosSensoriaisRepository.save(dadosSensoriais);
    }

    @Transactional(readOnly = true)
    public List<DadosSensoriais> findByDataHora(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal) {
        return dadosSensoriaisRepository.findByRangeTime(dataHoraInicial, dataHoraFinal);
    }

    @Transactional(readOnly = true)
    public List<DadosSensoriais> findBySensor(String sensor) {
        return dadosSensoriaisRepository.findBySensor(sensor);
    }
}
