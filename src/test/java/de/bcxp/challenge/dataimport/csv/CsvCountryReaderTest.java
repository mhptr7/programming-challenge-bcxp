package de.bcxp.challenge.dataimport.csv;

import de.bcxp.challenge.model.Country;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvCountryReaderTest {

    @Test
    void csvIsParsedToModelCorrectly() throws Exception {
        // given
        String pathToTestResource = "de/bcxp/challenge/csv/CsvCountryReaderTest/countries.csv";
        String expectedName = "Any Country";
        int expectedPopulation = 2000;
        int expectedArea = 12345;

        // when
        List<Country> countryList = new CsvCountryReader().parseToCountry(pathToTestResource);
        Country country = countryList.get(0);

        // then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(country.getName()).isEqualTo(expectedName);
        softly.assertThat(country.getPopulation()).isEqualTo(expectedPopulation);
        softly.assertThat(country.getAreaKm2()).isEqualTo(expectedArea);
        softly.assertAll();
    }
}