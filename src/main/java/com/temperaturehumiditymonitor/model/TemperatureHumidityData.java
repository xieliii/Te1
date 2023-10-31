package com.temperaturehumiditymonitor.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class TemperatureHumidityData {
    private Long id;
    private BigDecimal temperature;
    private BigDecimal humidity;
    private LocalDateTime timestamp;
}
