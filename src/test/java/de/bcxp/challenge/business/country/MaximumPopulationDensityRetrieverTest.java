package de.bcxp.challenge.business.country;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.MockCountry;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;

class MaximumPopulationDensityRetrieverTest {

    CountryUtils countryUtils = Mockito.mock(CountryUtils.class);
    MaximumPopulationDensityRetriever maximumPopulationDensityRetriever = new MaximumPopulationDensityRetriever(countryUtils);

    @Test
    void returnsFilterByMaximumPopulationDensityIfDensityIsPresent() {
        // given
        List<String> expectedResult = List.of("Country 1", "Country 2", "Country 3", "Country 4");
        List<Country> filterResult = expectedResult.stream()
                .map(name -> MockCountry.createCountry(name, null, null))
                .collect(Collectors.toList());
        Mockito.when(countryUtils.retrieveMaximumPopulationDensity(any())).thenReturn(Optional.of(1.0));
        Mockito.when(countryUtils.filterByPopulationDensity(any(), anyDouble())).thenReturn(filterResult);

        // when
        List<String> result = maximumPopulationDensityRetriever.execute(List.of());

        // then
        assertThat(result).containsExactly(expectedResult.toArray(new String[]{}));
    }


    @Test
    void throwsExceptionIfDensityIsNotPresent() {
        // given
        Mockito.when(countryUtils.retrieveMaximumPopulationDensity(any())).thenReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> maximumPopulationDensityRetriever.execute(List.of())).isInstanceOf(RuntimeException.class);
    }

}