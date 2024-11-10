package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.MockWeather;
import de.bcxp.challenge.model.Weather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class TemperatureSpreadCalculatorTest {

    final WeatherValidator weatherValidator = Mockito.mock(WeatherValidator.class);
    final TemperatureSpreadCalculator temperatureSpreadCalculator = new TemperatureSpreadCalculator(weatherValidator);

    @ParameterizedTest
    @CsvSource({
            "11, 11, 0",
            "21, 8, 13"
    })
    void spreadIsCalculatedCorrectly(int maxTemperature, int minTemperature, int expectedDifference) {
        // given
        Weather weather = MockWeather.createWeather(1, maxTemperature, minTemperature);
        Mockito.when(weatherValidator.validateWeather(any())).thenReturn(true);

        // when
        int difference = temperatureSpreadCalculator.calculateTemperatureSpread(weather);

        // then
        assertThat(difference).isEqualTo(expectedDifference);
    }

    @Test
    void invalidWeatherThrowsException() {
        // given
        Weather weather = Mockito.mock(Weather.class);
        Mockito.when(weatherValidator.validateWeather(any())).thenReturn(false);

        // when & then
        assertThatThrownBy(() -> temperatureSpreadCalculator.calculateTemperatureSpread(weather))
                .isInstanceOf(IllegalArgumentException.class);
    }

}