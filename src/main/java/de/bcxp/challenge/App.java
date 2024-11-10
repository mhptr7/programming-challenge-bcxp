package de.bcxp.challenge;

import de.bcxp.challenge.business.country.CountryUtils;
import de.bcxp.challenge.business.country.MaximumPopulationDensityRetriever;
import de.bcxp.challenge.business.weather.MinTemperatureSpreadRetriever;
import de.bcxp.challenge.business.weather.WeatherUtils;
import de.bcxp.challenge.dataimport.CountryDataReader;
import de.bcxp.challenge.dataimport.WeatherDataReader;
import de.bcxp.challenge.dataimport.csv.CsvCountryReader;
import de.bcxp.challenge.dataimport.csv.CsvWeatherReader;
import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.Weather;

import java.util.List;
import java.util.stream.Collectors;

public final class App {

    private static final String weatherCsvResourcePath = "de/bcxp/challenge/weather.csv";
    private static final String countriesCsvResourcePath = "de/bcxp/challenge/countries.csv";
    private static final WeatherDataReader weatherDataReader = new CsvWeatherReader();
    private static final CountryDataReader countryDataReader = new CsvCountryReader();

    public static void main(String... args) {
        MinTemperatureSpreadRetriever minTemperatureSpreadRetriever =
                new MinTemperatureSpreadRetriever(new WeatherUtils());
        List<Integer> result = minTemperatureSpreadRetriever.execute(readWeatherData());
        System.out.printf("Day(s) with smallest temperature spread: %s\n",
                result.stream().map(Object::toString).collect(Collectors.joining(", ")));

        MaximumPopulationDensityRetriever maximumPopulationDensityRetriever =
                new MaximumPopulationDensityRetriever(new CountryUtils());
        List<String> result2 = maximumPopulationDensityRetriever.execute(readCountryData());
        System.out.printf("Country/countries with highest population density: %s\n",
                String.join(", ", result2));
    }

    private static List<Weather> readWeatherData() {
        try {
            return weatherDataReader.parseToWeather(weatherCsvResourcePath);
        } catch (Exception e) {
            throw new RuntimeException("Could not read data! See log for more details!");
        }
    }

    private static List<Country> readCountryData() {
        try {
            return countryDataReader.parseToCountry(countriesCsvResourcePath);
        } catch (Exception e) {
            throw new RuntimeException("Could not read data! See log for more details!");
        }
    }
}
