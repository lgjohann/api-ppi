package com.arduinoppi.apippi.service;

import com.arduinoppi.apippi.repository.DadosSensoriaisRepository;
import com.arduinoppi.apippi.domain.DadosSensoriais;
import com.arduinoppi.apippi.web.dto.PesquisaDTO;
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
    public List<DadosSensoriais> findByDataHora(PesquisaDTO pesquisaDTO) {
        return dadosSensoriaisRepository.findByRangeTime(pesquisaDTO.getDataInicial(), pesquisaDTO.getDataFinal());
    }

    @Transactional(readOnly = true)
    public List<DadosSensoriais> findBySensor(PesquisaDTO pesquisaDTO) {
        return dadosSensoriaisRepository.findBySensor(pesquisaDTO.getSensor());
    }

    @Transactional(readOnly = true)
    public List<DadosSensoriais> findByDataHoraSensor(PesquisaDTO pesquisaDTO) {
        return dadosSensoriaisRepository.findByRangeTimeSensor(pesquisaDTO.getDataInicial(), pesquisaDTO.getDataFinal(), pesquisaDTO.getSensor());

    }
}
