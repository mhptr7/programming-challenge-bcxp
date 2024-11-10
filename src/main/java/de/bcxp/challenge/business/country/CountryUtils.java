package de.bcxp.challenge.business.country;


import de.bcxp.challenge.model.Country;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryUtils {

    private final PopulationDensityCalculator populationDensityCalculator =
            new PopulationDensityCalculator(new CountryValidator());

    public Optional<Double> retrieveMaximumPopulationDensity(List<Country> countryList) {
        return countryList.stream().map(populationDensityCalculator::calculationPopulationDensity).max(Comparator.naturalOrder());
    }

    public List<Country> filterByPopulationDensity(List<Country> countryList, double populationDensity) {
        return countryList.stream()
                .filter(country -> populationDensityCalculator.calculationPopulationDensity(country) == populationDensity)
                .collect(Collectors.toList());
    }

}
