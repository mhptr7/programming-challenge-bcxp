package de.bcxp.challenge.business.country;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.MockCountry;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class CountryUtilsTest {

    final CountryUtils countryUtils = new CountryUtils();

    @Test
    void testCalculateMaximumPopulationDensity() {
        // given
        Country country = MockCountry.createCountry("Country 1", 2, 100);
        Country countryWithMaxPopulationDensity1 = MockCountry.createCountry("Country 1", 50, 100);
        Country countryWithMaxPopulationDensity2 = MockCountry.createCountry("Country 1", 30, 60);

        // when
        Optional<Double> maximumPopulationDensity = countryUtils.retrieveMaximumPopulationDensity(List.of(
                country,
                countryWithMaxPopulationDensity1,
                countryWithMaxPopulationDensity2
        ));

        // then
        assertThat(maximumPopulationDensity).isPresent();
        assertThat(maximumPopulationDensity.get()).isEqualTo(0.5);
    }

    @Test
    void testFilterByPopulationDensityWithResults() {
        // given
        Country country = MockCountry.createCountry("Country 1", 2, 100);
        Country countryWithMaxPopulationDensity1 = MockCountry.createCountry("Country 1", 50, 100);
        Country countryWithMaxPopulationDensity2 = MockCountry.createCountry("Country 1", 30, 60);

        // when
        List<Country> countryListWithMaximumPopulationDensity =
                countryUtils.filterByPopulationDensity(List.of(
                   country,
                   countryWithMaxPopulationDensity1,
                   countryWithMaxPopulationDensity2
                ), 0.5);

        // then
        assertThat(countryListWithMaximumPopulationDensity).containsAll(
                Set.of(countryWithMaxPopulationDensity1, countryWithMaxPopulationDensity2)
        );
    }

    @Test
    void testFilterByPopulationDensityWithoutResults() {
        // given
        Country country = MockCountry.createCountry("Country 1", 2, 100);
        Country countryWithMaxPopulationDensity1 = MockCountry.createCountry("Country 1", 50, 100);
        Country countryWithMaxPopulationDensity2 = MockCountry.createCountry("Country 1", 30, 60);

        // when
        List<Country> countryListWithMaximumPopulationDensity =
                countryUtils.filterByPopulationDensity(List.of(
                        country,
                        countryWithMaxPopulationDensity1,
                        countryWithMaxPopulationDensity2
                ), 0.55);

        // then
        assertThat(countryListWithMaximumPopulationDensity).isEmpty();
    }
}