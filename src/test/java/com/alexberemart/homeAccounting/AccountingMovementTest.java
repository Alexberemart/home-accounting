package com.alexberemart.homeAccounting;

import com.alexberemart.homeAccounting.services.AccountingMovementServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:com/alexberemart/homeAccounting/context.xml"
})
public class AccountingMovementTest {

    @Autowired
    AccountingMovementServices ingAccountingMovementServices;

    @Autowired
    AccountingMovementServices bbvaAccountingMovementServices;

    @Test
    public void getAccountingMovements() throws IOException, ParseException {
        InputStream is = getClass().getResourceAsStream("/com/alexberemart/homeAccounting/ing.csv");
        ingAccountingMovementServices.getAccountingMovements(is);

    }

    @Test
    public void getBBVAAccountingMovements() throws IOException, ParseException {
        InputStream is = getClass().getResourceAsStream("/com/alexberemart/homeAccounting/bbva.csv");
        bbvaAccountingMovementServices.getAccountingMovements(is);
    }
}
