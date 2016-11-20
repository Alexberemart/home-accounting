package com.alexberemart.homeAccounting.factories;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;

public class CsvFactory {

    private String[] headers;

    public Iterable<CSVRecord> readCvs(Reader in) throws IOException {
        return CSVFormat.RFC4180.withHeader(headers).parse(in);
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
}
