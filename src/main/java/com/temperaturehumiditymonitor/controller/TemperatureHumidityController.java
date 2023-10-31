package com.temperaturehumiditymonitor.controller;

import com.temperaturehumiditymonitor.model.TemperatureHumidityData;
import com.temperaturehumiditymonitor.model.ThresholdSettings;
import com.temperaturehumiditymonitor.service.TemperatureHumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/temperature-humidity")
public class TemperatureHumidityController {

    @Autowired
    private TemperatureHumidityService temperatureHumidityService;

    @PostMapping("/setThreshold")
    public ResponseEntity<String> setThreshold(@RequestBody ThresholdSettings settings) {
        temperatureHumidityService.setThreshold(settings);
        return ResponseEntity.ok("Threshold set successfully.");
    }

    @GetMapping("/getData")
    public ResponseEntity<TemperatureHumidityData> getLatestData() {
        return ResponseEntity.ok(temperatureHumidityService.getLatestData());
    }

    @PostMapping("/receiveData")
    public ResponseEntity<String> receiveData(@RequestBody TemperatureHumidityData data) {
        temperatureHumidityService.receiveData(data);
        return ResponseEntity.ok("Data received successfully.");
    }

}
