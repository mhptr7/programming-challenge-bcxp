package de.bcxp.challenge.dataimport.csv;

import de.bcxp.challenge.model.Weather;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvWeatherReaderTest {

    @Test
    void csvIsParsedToModelCorrectly() throws Exception {
        // given
        String pathToTestResource = "de/bcxp/challenge/csv/CsvWeatherReaderTest/weather.csv";
        int expectedDay = 1;
        int expectedMaxTemperature = 90;
        int expectedMinTemperature = 50;


        // when
        List<Weather> weatherList = new CsvWeatherReader().parseToWeather(pathToTestResource);
        Weather weather = weatherList.get(0);

        // then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(weather.getDay()).isEqualTo(expectedDay);
        softly.assertThat(weather.getMaxTemperature()).isEqualTo(expectedMaxTemperature);
        softly.assertThat(weather.getMinTemperature()).isEqualTo(expectedMinTemperature);
        softly.assertAll();
    }

}