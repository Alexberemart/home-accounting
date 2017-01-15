package com.alexberemart.homeAccounting.factories;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.model.domain.BankAccount;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.text.ParseException;

public class BbvaFactory extends AccountingMovementFactory{

    @Value("${headers.bbva}")
    private String[] headers;

    public AccountingMovement getAccountingMovementsFromCSVRecord(CSVRecord record, BankAccount bankAccount) throws ParseException {
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
