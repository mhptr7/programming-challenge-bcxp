package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.Weather;

public class TemperatureSpreadCalculator {

    private final WeatherValidator weatherValidator;

    public TemperatureSpreadCalculator(WeatherValidator weatherValidator) {
        this.weatherValidator = weatherValidator;
    }

    public int calculateTemperatureSpread(Weather weather) {
        if (weatherValidator.validateWeather(weather)) {
            return weather.getMaxTemperature() - weather.getMinTemperature();
        } else {
            throw new IllegalArgumentException(String.format(
                    "Invalid weather! Day: %s, MaxTemperature: %s, MinTemperature: %s", // %s since values can be null!
                    weather.getDay(),
                    weather.getMaxTemperature(),
                    weather.getMinTemperature()
            ));
        }
    }

}
