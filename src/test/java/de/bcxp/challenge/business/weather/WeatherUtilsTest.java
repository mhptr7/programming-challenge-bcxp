package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.MockWeather;
import de.bcxp.challenge.model.Weather;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WeatherUtilsTest {

    final WeatherUtils weatherUtils = new WeatherUtils();

    @Test
    void testCalculateMinimumTemperatureSpread() {
        // given
        Weather weather = MockWeather.createWeather(1, 10, 5);
        Weather weatherWithMinSpread1 = MockWeather.createWeather(2, 50, 46);
        Weather weatherWithMinSpread2 = MockWeather.createWeather(3, 9, 5);

        // when
        Optional<Integer> minimumTemperatureSpread = weatherUtils.retrieveMinimumTemperatureSpread(List.of(
                weather,
                weatherWithMinSpread1,
                weatherWithMinSpread2
        ));

        // then
        assertThat(minimumTemperatureSpread).isPresent();
        assertThat(minimumTemperatureSpread.get()).isEqualTo(4);
    }

    @Test
    void testFilterByTemperatureSpreadWithResults() {
        // given
        Weather weather = MockWeather.createWeather(1, 10, 5);
        Weather weatherWithMinSpread1 = MockWeather.createWeather(2, 50, 46);
        Weather weatherWithMinSpread2 = MockWeather.createWeather(3, 9, 5);

        // when
        List<Weather> weatherListWithTemperatureSpread =
                weatherUtils.filterByTemperatureSpread(List.of(
                        weather,
                        weatherWithMinSpread1,
                        weatherWithMinSpread2
                ), 4);

        // then
        assertThat(weatherListWithTemperatureSpread).containsAll(
                Set.of(weatherWithMinSpread1, weatherWithMinSpread2)
        );
    }

    @Test
    void testFilterByTemperatureSpreadWithoutResults() {
        // given
        Weather weather = MockWeather.createWeather(1, 10, 5);
        Weather weatherWithMinSpread1 = MockWeather.createWeather(2, 50, 46);
        Weather weatherWithMinSpread2 = MockWeather.createWeather(3, 9, 5);

        // when
        List<Weather> weatherListWithTemperatureSpread =
                weatherUtils.filterByTemperatureSpread(List.of(
                        weather,
                        weatherWithMinSpread1,
                        weatherWithMinSpread2
                ), 6);

        // then
        assertThat(weatherListWithTemperatureSpread).isEmpty();
    }

}