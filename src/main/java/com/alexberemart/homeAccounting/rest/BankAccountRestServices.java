package com.alexberemart.homeAccounting.rest;

import com.alexberemart.homeAccounting.model.domain.BankAccount;
import com.alexberemart.homeAccounting.services.BankAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bankAccount")
public class BankAccountRestServices {

    @Autowired
    BankAccountServices bankAccountServices;

    @RequestMapping(path = "/findAll", method = RequestMethod.GET)
    public HttpEntity<List<BankAccount>> findAll() {
        List<BankAccount> result = bankAccountServices.findAll();
        return new ResponseEntity<List<BankAccount>>(result, HttpStatus.OK);
    }
}
