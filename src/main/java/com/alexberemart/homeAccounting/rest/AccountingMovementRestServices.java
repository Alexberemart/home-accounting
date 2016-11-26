package com.alexberemart.homeAccounting.rest;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.services.AccountingMovementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

@RestController
public class AccountingMovementRestServices {

    @Autowired
    AccountingMovementServices ingAccountingMovementServices;

    @Autowired
    AccountingMovementServices bbvaAccountingMovementServices;

    @RequestMapping(path = "/greeting", method = RequestMethod.POST)
    public HttpEntity<List<AccountingMovement>> greeting(@RequestBody String input) throws IOException, ParseException {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        List<AccountingMovement> result = ingAccountingMovementServices.getAccountingMovements(is);
        return new ResponseEntity<List<AccountingMovement>>(result, HttpStatus.OK);
    }


}
