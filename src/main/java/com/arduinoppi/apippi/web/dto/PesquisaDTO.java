package com.arduinoppi.apippi.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class PesquisaDTO {

    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private String sensor;
}
