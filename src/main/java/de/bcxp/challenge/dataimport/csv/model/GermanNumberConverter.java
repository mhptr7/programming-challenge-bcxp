package de.bcxp.challenge.dataimport.csv.model;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class GermanNumberConverter extends AbstractBeanField<Integer, String> {

    @Override
    protected Integer convert(String value) throws CsvDataTypeMismatchException {
        if (value == null || value.isEmpty()) {
            return null;
        }

        NumberFormat germanNumberFormat = NumberFormat.getInstance(Locale.GERMAN);
        try {
            return germanNumberFormat.parse(value).intValue();
        } catch (ParseException e) {
            throw new CsvDataTypeMismatchException(String.format("Cannot parse %s to an integer!", value));
        }
    }
}
