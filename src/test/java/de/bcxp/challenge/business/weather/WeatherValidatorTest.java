package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.MockWeather;
import de.bcxp.challenge.model.Weather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class WeatherValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 10, 5",
            "1, 11, 11"
    })
    void returnsTrueForValidWeather(int day, int maxTemperature, int minTemperature) {
        // given
        Weather weather = MockWeather.createWeather(day, maxTemperature, minTemperature);

        // when
        boolean isValid = new WeatherValidator().validateWeather(weather);

        // then
        assertThat(isValid).isTrue();
    }

    @Test
    void returnsFalseIfMinTemperatureGreaterThanMaxTemperature() {
        // given
        Weather weather = MockWeather.createWeather(1, 5, 6);

        // when
        boolean isValid = new WeatherValidator().validateWeather(weather);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    void returnsFalseIfDayNull() {
        // given
        Weather weather = MockWeather.createWeather(null, 10, 5);

        // when
        boolean isValid = new WeatherValidator().validateWeather(weather);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    void returnsFalseIfMaxTemperatureNull() {
        // given
        Weather weather = MockWeather.createWeather(1, null, 5);

        // when
        boolean isValid = new WeatherValidator().validateWeather(weather);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    void returnsFalseIfMinTemperatureNull() {
        // given
        Weather weather = MockWeather.createWeather(1, 10, null);

        // when
        boolean isValid = new WeatherValidator().validateWeather(weather);

        // then
        assertThat(isValid).isFalse();
    }
}