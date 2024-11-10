package de.bcxp.challenge.business.country;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.MockCountry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CountryValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "Country 1, 100, 10",
            "Country 2, 0, 5"
    })
    void returnsTrueForValidCountry(String name, int population, int areaKm2) {
        // given
        Country country = MockCountry.createCountry(name, population, areaKm2);

        // when
        boolean isValid = new CountryValidator().validateCountry(country);

        // then
        assertThat(isValid).isTrue();
    }

    @Test
    void returnsFalseIfAreaKm2IsZero() {
        // given
        Country country = MockCountry.createCountry("Country 1", 100, 0);

        // when
        boolean isValid = new CountryValidator().validateCountry(country);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    void returnsFalseIfNameIsNull() {
        // given
        Country country = MockCountry.createCountry(null, 100, 10);

        // when
        boolean isValid = new CountryValidator().validateCountry(country);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    void returnsFalseIfPopulationIsNull() {
        // given
        Country country = MockCountry.createCountry("Country 1", null, 10);

        // when
        boolean isValid = new CountryValidator().validateCountry(country);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    void returnsFalseIfAreaKm2IsNull() {
        // given
        Country country = MockCountry.createCountry("Country 1", 100, null);

        // when
        boolean isValid = new CountryValidator().validateCountry(country);

        // then
        assertThat(isValid).isFalse();
    }



}