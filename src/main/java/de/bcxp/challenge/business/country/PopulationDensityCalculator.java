package de.bcxp.challenge.business.country;

import de.bcxp.challenge.model.Country;

public class PopulationDensityCalculator {

    private final CountryValidator countryValidator;


    public PopulationDensityCalculator(CountryValidator countryValidator) {
        this.countryValidator = countryValidator;
    }

    public double calculationPopulationDensity(Country country) {
        if (countryValidator.validateCountry(country)) {
            return country.getPopulation() / ((double) country.getAreaKm2());
        } else {
            throw new IllegalArgumentException(String.format(
                    "Invalid country! Name: %s, Population: %s, Area (km²): %s", // %s since values can be null!
                    country.getName(),
                    country.getPopulation(),
                    country.getAreaKm2())
            );
        }
    }
}
