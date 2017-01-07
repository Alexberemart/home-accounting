package com.alexberemart.homeAccounting.model.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;

public class AccountingMovementGroupByDate {

    protected Date date;
    protected Double amount;

    public AccountingMovementGroupByDate() {
    }

    public AccountingMovementGroupByDate(HashMap map) throws JsonProcessingException {
        this.date = (Date) map.get("date");
        this.amount = (Double) map.get("amount");
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
