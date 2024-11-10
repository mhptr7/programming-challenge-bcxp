package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.MockWeather;
import de.bcxp.challenge.model.Weather;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

class MinTemperatureSpreadRetrieverTest {

    WeatherUtils weatherUtils = Mockito.mock(WeatherUtils.class);
    MinTemperatureSpreadRetriever minTemperatureSpreadRetriever = new MinTemperatureSpreadRetriever(weatherUtils);

    @Test
    void returnsFilterByTemperatureSpreadResultIfSpreadIsPresent() {
        // given
        List<Integer> expectedResult = List.of(1, 2, 7, 11);
        List<Weather> filterResult = expectedResult.stream()
                .map(day -> MockWeather.createWeather(day, null, null))
                .collect(Collectors.toList());
        Mockito.when(weatherUtils.retrieveMinimumTemperatureSpread(any())).thenReturn(Optional.of(1));
        Mockito.when(weatherUtils.filterByTemperatureSpread(any(), anyInt())).thenReturn(filterResult);

        // when
        List<Integer> result = minTemperatureSpreadRetriever.execute(List.of());

        // then
        assertThat(result).containsExactly(expectedResult.toArray(new Integer[]{}));
    }

    @Test
    void throwsExceptionIfSpreadIsNotPresent() {
        // given
        Mockito.when(weatherUtils.retrieveMinimumTemperatureSpread(any())).thenReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> minTemperatureSpreadRetriever.execute(List.of())).isInstanceOf(RuntimeException.class);
    }

}