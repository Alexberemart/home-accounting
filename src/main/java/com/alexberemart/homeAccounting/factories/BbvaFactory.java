package com.alexberemart.homeAccounting.factories;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class BbvaFactory extends AccountingMovementFactory{

    private String[] headers;

    public AccountingMovement getAccountingMovementsFromCSVRecord(CSVRecord record) throws ParseException {
        AccountingMovement accountingMovement = new AccountingMovement();
        accountingMovement.setDate(getDateFromString(record.get(headers[1])));
        accountingMovement.setDescription(record.get(headers[3]));
        accountingMovement.setAmount(getFloatFromString(record.get(headers[5])));
        return accountingMovement;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
}
