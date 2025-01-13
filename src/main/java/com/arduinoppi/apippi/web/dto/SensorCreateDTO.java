package com.arduinoppi.apippi.web.dto;

import com.arduinoppi.apippi.domain.Sensor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SensorCreateDTO {

    private String name;
    private BigDecimal valorConfig;

    public Sensor toSensor() {
        Sensor sensor = new Sensor();
        sensor.setNome(this.name);
        sensor.setValorConfig(this.valorConfig);
        return sensor;
    }
}
