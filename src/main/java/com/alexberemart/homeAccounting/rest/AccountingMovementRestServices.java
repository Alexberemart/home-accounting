package com.alexberemart.homeAccounting.rest;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.model.domain.AccountingMovementGroupByDate;
import com.alexberemart.homeAccounting.services.AccountingMovementServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/accountingMovement")
public class AccountingMovementRestServices {

    @Autowired
    AccountingMovementServices ingAccountingMovementServices;

    @Autowired
    AccountingMovementServices bbvaAccountingMovementServices;

    @RequestMapping(path = "/{bankAccountId}", method = RequestMethod.POST)
    public HttpEntity<List<AccountingMovement>> save(@PathVariable("bankAccountId") Long bankAccountId, @RequestBody String input) throws IOException, ParseException {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        List<AccountingMovement> result = ingAccountingMovementServices.getAccountingMovements(is, bankAccountId);
        ingAccountingMovementServices.save(result);
        return new ResponseEntity<List<AccountingMovement>>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/findAll", method = RequestMethod.GET)
    public HttpEntity<List<AccountingMovement>> findAll() {
        List<AccountingMovement> result = ingAccountingMovementServices.findAll();
        return new ResponseEntity<List<AccountingMovement>>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/findAllOrderByDate", method = RequestMethod.GET)
    public HttpEntity<List<AccountingMovement>> findAllOrderByDate() {
        List<AccountingMovement> result = ingAccountingMovementServices.findAllByOrderByDate();
        return new ResponseEntity<List<AccountingMovement>>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/getAmountGroupByDate", method = RequestMethod.GET)
    public HttpEntity<List<AccountingMovementGroupByDate>> getAmountGroupByDate() throws JsonProcessingException {
        List<AccountingMovementGroupByDate> result = ingAccountingMovementServices.getAmountGroupByDate();
        return new ResponseEntity<List<AccountingMovementGroupByDate>>(result, HttpStatus.OK);
    }

    @RequestMapping(path = "/getAmountAccumulatedByDate", method = RequestMethod.GET)
    public HttpEntity<List<AccountingMovementGroupByDate>> getAmountAccumulatedByDate() {
        List<AccountingMovementGroupByDate> result = ingAccountingMovementServices.getAmountAccumulatedByDate();
        return new ResponseEntity<List<AccountingMovementGroupByDate>>(result, HttpStatus.OK);
    }

}
