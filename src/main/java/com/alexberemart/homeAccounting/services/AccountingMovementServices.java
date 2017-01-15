package com.alexberemart.homeAccounting.services;

import com.alexberemart.homeAccounting.factories.AccountingMovementFactory;
import com.alexberemart.homeAccounting.factories.CsvFactory;
import com.alexberemart.homeAccounting.model.dao.PersonRepository;
import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.model.domain.AccountingMovementGroupByDate;
import com.alexberemart.homeAccounting.model.domain.BankAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountingMovementServices {

    private AccountingMovementFactory accountingMovementFactory;
    private CsvFactory csvFactory;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    BankAccountServices bankAccountServices;

    public List<AccountingMovement> getAccountingMovements(InputStream is, Long bankAccountId) throws IOException, ParseException {

        List<AccountingMovement> result = new ArrayList<AccountingMovement>();

        BankAccount bankAccount = bankAccountServices.findById(bankAccountId);

        Reader in = new InputStreamReader(is);
        Iterable<CSVRecord> records = csvFactory.readCvs(in);
        for (CSVRecord record : records) {
            result.add(accountingMovementFactory.getAccountingMovementsFromCSVRecord(record, bankAccount));
        }

        return result;
    }

    public void save(List<AccountingMovement> accountingMovements) {
        for (AccountingMovement accountingMovement : accountingMovements) {
            personRepository.save(accountingMovement);
        }
    }

    public List<AccountingMovement> findAll() {
        return (List<AccountingMovement>) personRepository.findAll();
    }

    public List<AccountingMovement> findAllByOrderByDate() {
        return personRepository.findAllByOrderByDate();
    }

    public List<AccountingMovementGroupByDate> getAmountGroupByDate() throws JsonProcessingException {
        return personRepository.getAmountGroupByDate();
    }

    public List<AccountingMovementGroupByDate> getAmountAccumulatedByDate() {
        List<AccountingMovementGroupByDate> result = new ArrayList<AccountingMovementGroupByDate>();
        Double accumulatedAmount = 0.0D;
        List<AccountingMovementGroupByDate> accountingMovementGroupByDateList = personRepository.getAmountGroupByDate();
        for (AccountingMovementGroupByDate accountingMovementGroupByDate : accountingMovementGroupByDateList){
            accumulatedAmount += accountingMovementGroupByDate.getAmount();

            AccountingMovementGroupByDate accountingMovementGroupByDate1 = new AccountingMovementGroupByDate();
            accountingMovementGroupByDate1.setDate(accountingMovementGroupByDate.getDate());
            accountingMovementGroupByDate1.setAmount(accumulatedAmount);
            result.add(accountingMovementGroupByDate1);
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
