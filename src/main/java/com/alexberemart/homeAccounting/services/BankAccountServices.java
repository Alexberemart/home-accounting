package com.alexberemart.homeAccounting.services;

import com.alexberemart.homeAccounting.model.dao.BankAccountRepository;
import com.alexberemart.homeAccounting.model.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServices {

    @Autowired
    BankAccountRepository bankAccountRepository;

    public BankAccount findById(Long id) {
        return bankAccountRepository.findById(id);
    }
}
