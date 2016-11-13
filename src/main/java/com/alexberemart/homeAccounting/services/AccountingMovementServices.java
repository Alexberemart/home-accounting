package com.alexberemart.homeAccounting.services;

import com.alexberemart.homeAccounting.factories.AccountingMovementFactory;
import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AccountingMovementServices {

    private String[] headers;
    private AccountingMovementFactory accountingMovementFactory;

    public List<AccountingMovement> getAccountingMovements(InputStream is) throws IOException, ParseException {

        List<AccountingMovement> result = new ArrayList<AccountingMovement>();

        Reader in = new InputStreamReader(is);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(headers).parse(in);
        for (CSVRecord record : records) {
            accountingMovementFactory.setHeaders(headers);
            result.add(accountingMovementFactory.getAccountingMovementsFromCSVRecord(record));
        }

        return result;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public void setAccountingMovementFactory(AccountingMovementFactory accountingMovementFactory) {
        this.accountingMovementFactory = accountingMovementFactory;
    }
}
