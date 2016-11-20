package com.alexberemart.homeAccounting.model.dao;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.services.AccountingMovementServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:com/alexberemart/homeAccounting/context.xml"
})
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AccountingMovementServices bbvaAccountingMovementServices;

    @Test
    public void getAccountingMovements() throws IOException, ParseException {
        personRepository.findAll();
    }

    @Test
    public void getAccountingMovements2() throws IOException, ParseException {
        InputStream is = getClass().getResourceAsStream("/com/alexberemart/homeAccounting/bbva.csv");
        List<AccountingMovement> accountingMovements = bbvaAccountingMovementServices.getAccountingMovements(is);
        personRepository.save(accountingMovements.get(0));
    }
}
