package de.bcxp.challenge.model;

import org.mockito.Mockito;

public final class MockCountry {

    private MockCountry() {}

    public static Country createCountry(String name, Integer population, Integer areaKm2) {
        Country country = Mockito.mock(Country.class);
        Mockito.when(country.getName()).thenReturn(name);
        Mockito.when(country.getPopulation()).thenReturn(population);
        Mockito.when(country.getAreaKm2()).thenReturn(areaKm2);
        return country;
    }

}
