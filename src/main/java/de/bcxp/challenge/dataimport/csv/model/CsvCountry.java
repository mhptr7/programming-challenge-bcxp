package de.bcxp.challenge.dataimport.csv.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import de.bcxp.challenge.model.Country;

public class CsvCountry implements Country {

    @CsvBindByName(column = "Name")
    private String name;

    @CsvCustomBindByName(column = "Population", converter  = GermanNumberConverter.class)
    private Integer population;

    @CsvBindByName(column = "Area (km²)")
    private Integer areaKm2;

    public String getName() {
        return name;
    }

    public Integer getPopulation() {
        return population;
    }

    public Integer getAreaKm2() {
        return areaKm2;
    }
}
