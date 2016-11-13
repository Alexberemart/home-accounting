package com.alexberemart.homeAccounting.model.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountingMovement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
