package com.temperaturehumiditymonitor.service;

import com.temperaturehumiditymonitor.model.TemperatureHumidityData;
import com.temperaturehumiditymonitor.model.ThresholdSettings;
import java.math.BigDecimal;
import java.util.List;

public interface TemperatureHumidityService {

    /**
     * Set the threshold for temperature and humidity.
     * @param settings The threshold settings.
     */
    void setThreshold(ThresholdSettings settings);

    /**
     * Get the latest temperature and humidity data.
     * @return The latest data.
     */
    TemperatureHumidityData getLatestData();

    /**
     * Handle the exception when temperature or humidity exceeds the threshold.
     * @param data The data that caused the exception.
     */
    String handleException(TemperatureHumidityData data);

    /**
     * Receive new temperature and humidity data.
     * @param data The new data.
     */
    void receiveData(TemperatureHumidityData data);

    /**
     * Get all temperature and humidity data.
     * @return A list of all data.
     */
    List<TemperatureHumidityData> getAllData();

    /**
     * Check if the provided data exceeds the threshold.
     * @param temperature The temperature to check.
     * @param humidity The humidity to check.
     * @return true if the data exceeds the threshold, false otherwise.
     */
    boolean isExceedingThreshold(BigDecimal temperature, BigDecimal humidity);
}
