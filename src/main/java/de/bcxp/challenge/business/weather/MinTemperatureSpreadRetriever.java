package de.bcxp.challenge.business.weather;

import de.bcxp.challenge.model.Weather;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinTemperatureSpreadRetriever {

    private final WeatherUtils weatherUtils;

    public MinTemperatureSpreadRetriever(WeatherUtils weatherUtils) {
        this.weatherUtils = weatherUtils;
    }

    public List<Integer> execute(List<Weather> weatherList) {
        Optional<Integer> minimumTemperatureSpread = weatherUtils.retrieveMinimumTemperatureSpread(weatherList);
        if (minimumTemperatureSpread.isPresent()) {
            return weatherUtils.filterByTemperatureSpread(weatherList, minimumTemperatureSpread.get())
                    .stream().map(Weather::getDay).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Could not calculate the minimum temperature spread from the parsed data!");
        }
    }
}
