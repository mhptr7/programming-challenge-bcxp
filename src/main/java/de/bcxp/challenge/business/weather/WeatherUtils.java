package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.Weather;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherUtils {

    private final TemperatureSpreadCalculator temperatureSpreadCalculator =
            new TemperatureSpreadCalculator(new WeatherValidator());

    public Optional<Integer> retrieveMinimumTemperatureSpread(List<Weather> weatherList) {
        return weatherList.stream().map(temperatureSpreadCalculator::calculateTemperatureSpread).min(Comparator.naturalOrder());
    }

    public List<Weather> filterByTemperatureSpread(List<Weather> weatherList, int temperatureSpread) {
        return weatherList.stream()
                .filter(weather -> temperatureSpreadCalculator.calculateTemperatureSpread(weather) == temperatureSpread)
                .collect(Collectors.toList());
    }
}
