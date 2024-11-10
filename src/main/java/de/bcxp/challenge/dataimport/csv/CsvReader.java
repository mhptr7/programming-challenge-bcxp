package de.bcxp.challenge.dataimport.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class CsvReader<T, V extends T> {

    protected List<T> parse(String resourcePath, Class<V> clazz, char separator) throws IOException, URISyntaxException {
        try (Reader reader = Files.newBufferedReader(getPathForResource(resourcePath))) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withSeparator(separator)
                    .build();
            return csvToBean.parse();
        }
    }

    private Path getPathForResource(String resourcePath) throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(resourcePath);
        if (resource != null) {
            return Paths.get(resource.toURI());
        } else {
            throw new IllegalArgumentException(String.format("Could not get resource from path %s!", resourcePath));
        }
    }
}
