package com.alexberemart.homeAccounting.model.domain;

import java.util.Date;

/**
 * Created by Alex on 12/11/2016.
 */
public class AccountingMovement {

    protected String id;
    protected Date date;
    protected String description;
    protected Float amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
