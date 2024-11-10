package de.bcxp.challenge.dataimport;

import de.bcxp.challenge.model.Weather;

import java.util.List;

public interface WeatherDataReader {
    List<Weather> parseToWeather(String resourcePath) throws Exception;
}
