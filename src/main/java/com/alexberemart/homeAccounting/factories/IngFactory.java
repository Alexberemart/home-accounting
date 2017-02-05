package com.alexberemart.homeAccounting.factories;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.model.domain.BankAccount;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;

public class IngFactory extends AccountingMovementFactory{

    @Value("${headers.ing}")
    private String[] headers;

    public AccountingMovement getAccountingMovementsFromCSVRecord(CSVRecord record, BankAccount bankAccount) throws ParseException {
        AccountingMovement accountingMovement = new AccountingMovement();
        accountingMovement.setDate(getDateFromString(record.get(headers[0])));
        accountingMovement.setDescription(record.get(headers[1]));
        accountingMovement.setAmount(getFloatFromString(record.get(headers[4])));
        accountingMovement.setBankAccount(bankAccount);
        return accountingMovement;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
}
