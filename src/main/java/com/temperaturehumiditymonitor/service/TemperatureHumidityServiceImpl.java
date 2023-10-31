package com.temperaturehumiditymonitor.service;

import com.temperaturehumiditymonitor.model.TemperatureHumidityData;
import com.temperaturehumiditymonitor.model.ThresholdSettings;
import com.temperaturehumiditymonitor.service.TemperatureHumidityService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class TemperatureHumidityServiceImpl implements TemperatureHumidityService {

    private ThresholdSettings currentThreshold = new ThresholdSettings();
    private final List<TemperatureHumidityData> dataList = new ArrayList<>();

    @Override
    public void setThreshold(ThresholdSettings settings) {
        this.currentThreshold.setMaxTemperature(settings.getMaxTemperature());
        this.currentThreshold.setMaxHumidity(settings.getMaxHumidity());
    }

    @Override
    public TemperatureHumidityData getLatestData() {
        return dataList.isEmpty() ? null : dataList.get(dataList.size() - 1);
    }

    @Override
    public String handleException(TemperatureHumidityData data) {
        return "Temperature: " + data.getTemperature() + "°C and Humidity: " + data.getHumidity() + "% have exceeded the set threshold.";
    }

    @Override
    public void receiveData(TemperatureHumidityData data) {
        dataList.add(data);
        if (isExceedingThreshold(data.getTemperature(), data.getHumidity())) {
            handleException(data);
        }
    }

    @Override
    public List<TemperatureHumidityData> getAllData() {
        return new ArrayList<>(dataList);
    }

    @Override
    public boolean isExceedingThreshold(BigDecimal temperature, BigDecimal humidity) {
        return (currentThreshold.getMaxTemperature() != null && temperature.compareTo(currentThreshold.getMaxTemperature()) > 0) ||
                (currentThreshold.getMaxHumidity() != null && humidity.compareTo(currentThreshold.getMaxHumidity()) > 0);
    }
}
