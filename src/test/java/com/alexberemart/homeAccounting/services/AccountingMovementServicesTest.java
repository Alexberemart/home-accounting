package com.alexberemart.homeAccounting.services;

import com.alexberemart.homeAccounting.factories.BbvaFactory;
import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.model.domain.AccountingMovementGroupByDate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:com/alexberemart/homeAccounting/context.xml"
})
@TestExecutionListeners(value = {
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(AccountingMovementServicesTest.BI_DATA_XML_DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { AccountingMovementServicesTest.BI_DATA_XML_DATASET})
public class AccountingMovementServicesTest {

    public static final String BI_DATA_XML_DATASET = "classpath:datasets/biDataEntry.xml";

    @Autowired
    AccountingMovementServices ingAccountingMovementServices;

    @Autowired
    AccountingMovementServices bbvaAccountingMovementServices;

    @Autowired
    BbvaFactory bbvaFactory;

    @Test
    @Ignore
    public void getAccountingMovements() throws IOException, ParseException {
        InputStream is = getClass().getResourceAsStream("/com/alexberemart/homeAccounting/ing.csv");
        List<AccountingMovement> accountingMovements = ingAccountingMovementServices.getAccountingMovements(is, 1L);
        Assert.assertNotNull(accountingMovements);
    }

    @Test
    public void getBBVAAccountingMovements() throws IOException, ParseException {
        InputStream is = getClass().getResourceAsStream("/com/alexberemart/homeAccounting/bbva.csv");
        bbvaAccountingMovementServices.getAccountingMovements(is, 1L);
    }

    @Test
    public void findAllOrderByDate() {
        List result = bbvaAccountingMovementServices.findAllByOrderByDate();
        Assert.assertNotNull(result);
    }

    @Test
    public void getAmountGroupByDate() throws JsonProcessingException {
        List result = bbvaAccountingMovementServices.getAmountGroupByDate();
        Assert.assertNotNull(result);
    }

    @Test
    public void getAmountAccumulatedByDate() {
        List<AccountingMovementGroupByDate> result = bbvaAccountingMovementServices.getAmountAccumulatedByDate();
        Assert.assertNotNull(result);
    }
}
