package de.bcxp.challenge.model;

import org.mockito.Mockito;

public final class MockWeather {

    private MockWeather() {}

    public static Weather createWeather(Integer day, Integer maxTemperature, Integer minTemperature) {
        Weather weather = Mockito.mock(Weather.class);
        Mockito.when(weather.getDay()).thenReturn(day);
        Mockito.when(weather.getMaxTemperature()).thenReturn(maxTemperature);
        Mockito.when(weather.getMinTemperature()).thenReturn(minTemperature);
        return weather;
    }

}
