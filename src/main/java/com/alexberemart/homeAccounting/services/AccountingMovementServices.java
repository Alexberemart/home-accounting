package com.alexberemart.homeAccounting.services;

import com.alexberemart.homeAccounting.factories.AccountingMovementFactory;
import com.alexberemart.homeAccounting.factories.CsvFactory;
import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AccountingMovementServices {

    private AccountingMovementFactory accountingMovementFactory;
    private CsvFactory csvFactory;

    public List<AccountingMovement> getAccountingMovements(InputStream is) throws IOException, ParseException {

        List<AccountingMovement> result = new ArrayList<AccountingMovement>();

        Reader in = new InputStreamReader(is);
        Iterable<CSVRecord> records = csvFactory.readCvs(in);
        for (CSVRecord record : records) {
            result.add(accountingMovementFactory.getAccountingMovementsFromCSVRecord(record));
        }

        return result;
    }

    public void setAccountingMovementFactory(AccountingMovementFactory accountingMovementFactory) {
        this.accountingMovementFactory = accountingMovementFactory;
    }

    public void setCsvFactory(CsvFactory csvFactory) {
        this.csvFactory = csvFactory;
    }
}
