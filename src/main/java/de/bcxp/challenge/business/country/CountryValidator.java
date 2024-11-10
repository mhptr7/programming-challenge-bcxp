package de.bcxp.challenge.business.country;

import de.bcxp.challenge.model.Country;

public class CountryValidator {

    public boolean validateCountry(Country country) {
        if (country.getName() != null && country.getPopulation() != null && country.getAreaKm2() != null) {
            return country.getAreaKm2() > 0;
        }
        return false;
    }

}
