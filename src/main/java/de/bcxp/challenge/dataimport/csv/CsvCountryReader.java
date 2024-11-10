package de.bcxp.challenge.dataimport.csv;

import de.bcxp.challenge.dataimport.CountryDataReader;
import de.bcxp.challenge.dataimport.csv.model.CsvCountry;
import de.bcxp.challenge.model.Country;

import java.util.List;

public class CsvCountryReader extends CsvReader<Country, CsvCountry> implements CountryDataReader {

    @Override
    public List<Country> parseToCountry(String resourcePath) throws Exception {
        return parse(resourcePath, CsvCountry.class, ';');
    }
}
