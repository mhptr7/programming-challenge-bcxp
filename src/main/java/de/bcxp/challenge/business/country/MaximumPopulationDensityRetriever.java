package de.bcxp.challenge.business.country;

import de.bcxp.challenge.model.Country;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaximumPopulationDensityRetriever {

    private final CountryUtils countryUtils;

    public MaximumPopulationDensityRetriever(CountryUtils countryUtils) {
        this.countryUtils = countryUtils;
    }

    public List<String> execute(List<Country> countryList) {
        Optional<Double> maximumPopulationDensity = countryUtils.retrieveMaximumPopulationDensity(countryList);
        if (maximumPopulationDensity.isPresent()) {
            return countryUtils.filterByPopulationDensity(countryList, maximumPopulationDensity.get())
                    .stream().map(Country::getName).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Could not calculate the maximum population density from the parsed data!");
        }
    }
}
