package com.alexberemart.homeAccounting.services;

import com.alexberemart.homeAccounting.model.dao.BankAccountRepository;
import com.alexberemart.homeAccounting.model.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServices {

    @Autowired
    BankAccountRepository bankAccountRepository;

    public BankAccount findById(Long id) {
        return bankAccountRepository.findById(id);
    }

    public List<BankAccount> findAll(){
        return (List<BankAccount>) bankAccountRepository.findAll();
    }
}
