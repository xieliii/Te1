package com.temperaturehumiditymonitor.controller;

import com.temperaturehumiditymonitor.model.TemperatureHumidityData;
import com.temperaturehumiditymonitor.model.ThresholdSettings;
import com.temperaturehumiditymonitor.service.TemperatureHumidityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TemperatureHumidityControllerTest {

    @InjectMocks
    private TemperatureHumidityController controller;

    @Mock
    private TemperatureHumidityService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetThreshold() {
        ThresholdSettings settings = new ThresholdSettings();
        doNothing().when(service).setThreshold(settings);

        ResponseEntity<String> response = controller.setThreshold(settings);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Threshold set successfully.", response.getBody());
    }

    @Test
    public void testGetLatestData() {
        TemperatureHumidityData data = new TemperatureHumidityData();
        when(service.getLatestData()).thenReturn(data);

        ResponseEntity<TemperatureHumidityData> response = controller.getLatestData();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(data, response.getBody());
    }

    @Test
    public void testReceiveData() {
        TemperatureHumidityData data = new TemperatureHumidityData();
        doNothing().when(service).receiveData(data);

        ResponseEntity<String> response = controller.receiveData(data);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Data received successfully.", response.getBody());
    }
}
