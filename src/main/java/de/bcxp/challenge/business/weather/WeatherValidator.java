package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.Weather;

public class WeatherValidator {

    public boolean validateWeather(Weather weather) {
        if (weather.getDay() != null && weather.getMaxTemperature() != null && weather.getMinTemperature() != null) {
            return weather.getMaxTemperature() >= weather.getMinTemperature();
        }
        return false;
    }

}
