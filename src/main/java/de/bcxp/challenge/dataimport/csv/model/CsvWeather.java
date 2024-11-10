package de.bcxp.challenge.dataimport.csv.model;

import com.opencsv.bean.CsvBindByName;
import de.bcxp.challenge.model.Weather;

public class CsvWeather implements Weather {

    @CsvBindByName(column = "Day")
    private Integer day;

    @CsvBindByName(column = "MxT")
    private Integer maxTemperature;

    @CsvBindByName(column = "MnT")
    private Integer minTemperature;

    public Integer getDay() {
        return day;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }
}
