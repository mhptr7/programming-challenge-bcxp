package de.bcxp.challenge.dataimport.csv;

import de.bcxp.challenge.dataimport.WeatherDataReader;
import de.bcxp.challenge.dataimport.csv.model.CsvWeather;
import de.bcxp.challenge.model.Weather;

import java.util.List;

public class CsvWeatherReader extends CsvReader<Weather, CsvWeather> implements WeatherDataReader {

    @Override
    public List<Weather> parseToWeather(String resourcePath) throws Exception {
        return parse(resourcePath, CsvWeather.class, ',');
    }
}
