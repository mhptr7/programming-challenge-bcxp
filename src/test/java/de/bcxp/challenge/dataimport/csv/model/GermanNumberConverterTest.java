package de.bcxp.challenge.dataimport.csv.model;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class GermanNumberConverterTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "100,00; 100",
                    "20.000,00; 20000"
            },
            delimiter = ';'
    )
    void convertTest(String value, Integer expectedResult) throws CsvDataTypeMismatchException {
        // given
        GermanNumberConverter germanNumberConverter = new GermanNumberConverter();

        // when
        Integer result = germanNumberConverter.convert(value);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}