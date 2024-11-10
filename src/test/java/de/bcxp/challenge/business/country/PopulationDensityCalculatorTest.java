package de.bcxp.challenge.business.country;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.MockCountry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class PopulationDensityCalculatorTest {

    final CountryValidator countryValidator = Mockito.mock(CountryValidator.class);
    final PopulationDensityCalculator populationDensityCalculator = new PopulationDensityCalculator(countryValidator);

    @ParameterizedTest
    @CsvSource({
            "0, 10, 0",
            "10, 20, 0.5",
            "100, 10, 10"
    })
    void populationDensityIsCalculatedCorrectly(int population, int areaKm2, double expectedPopulationDensity) {
        // given
        Country country = MockCountry.createCountry("Country 1", population, areaKm2);
        Mockito.when(countryValidator.validateCountry(any())).thenReturn(true);

        // when
        double populationDensity = populationDensityCalculator.calculationPopulationDensity(country);

        // then
        assertThat(populationDensity).isEqualTo(expectedPopulationDensity);
    }

    @Test
    void invalidCountryThrowsException() {
        // given
        Country country = Mockito.mock(Country.class);
        Mockito.when(countryValidator.validateCountry(any())).thenReturn(false);

        // when & then
        assertThatThrownBy(() -> populationDensityCalculator.calculationPopulationDensity(country))
                .isInstanceOf(IllegalArgumentException.class);
    }
}