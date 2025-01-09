package com.arduinoppi.apippi.web.dto;

import com.arduinoppi.apippi.domain.DadosSensoriais;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DadosSensoriaisCreateDTO {

    private Long leitura;
    private String sensor;

    public static DadosSensoriais toDados(DadosSensoriaisCreateDTO dto) {
        DadosSensoriais dados = new DadosSensoriais();
        dados.setLeitura(dto.getLeitura());
        dados.setSensor(dto.getSensor());
        dados.setDataHora(LocalDateTime.now());
        return dados;
    }

}
