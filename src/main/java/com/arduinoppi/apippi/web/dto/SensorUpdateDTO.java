package com.arduinoppi.apippi.web.dto;

import com.arduinoppi.apippi.domain.Sensor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SensorUpdateDTO {

    private String name;
    private BigDecimal valorConfig;

}
