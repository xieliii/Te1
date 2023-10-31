package com.temperaturehumiditymonitor.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ThresholdSettings {
    private Long id;
    private BigDecimal maxTemperature;
    private BigDecimal maxHumidity;
}
