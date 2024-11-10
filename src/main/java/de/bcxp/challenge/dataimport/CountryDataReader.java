package de.bcxp.challenge.dataimport;

import de.bcxp.challenge.model.Country;

import java.util.List;

public interface CountryDataReader {
    List<Country> parseToCountry(String resourcePath) throws Exception;
}
