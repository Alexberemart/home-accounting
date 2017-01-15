package com.alexberemart.homeAccounting.model.domain;

import com.alexberemart.homeAccounting.enums.Bank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    protected Bank bank;
    protected String description;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
}
