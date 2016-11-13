package com.alexberemart.homeAccounting.model.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:com/alexberemart/homeAccounting/context.xml"
})
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void getAccountingMovements() throws IOException, ParseException {
        personRepository.findAll();
    }
}
