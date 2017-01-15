package com.alexberemart.homeAccounting.model.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountingMovement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    protected Date date;
    protected String description;
    protected Float amount;

    @ManyToOne
    @JoinColumn(name="bank_account_id")
    protected BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
