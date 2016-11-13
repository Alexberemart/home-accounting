package com.alexberemart.homeAccounting.config;

import com.alexberemart.homeAccounting.factories.BbvaFactory;
import com.alexberemart.homeAccounting.factories.IngFactory;
import com.alexberemart.homeAccounting.services.AccountingMovementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class homeAccountingConfig {

    @Autowired
    IngFactory ingFactory;

    @Autowired
    BbvaFactory bbvaFactory;

    @Bean("ingAccountingMovementServices")
    public AccountingMovementServices getIngAccountingMovementServices(@Value("${headers.ing}") String[] headers) {
        AccountingMovementServices accountingMovementServices = new AccountingMovementServices();
        accountingMovementServices.setHeaders(headers);
        accountingMovementServices.setAccountingMovementFactory(ingFactory);
        return accountingMovementServices;
    }

    @Bean("bbvaAccountingMovementServices")
    public AccountingMovementServices getBbvaAccountingMovementServices(@Value("${headers.bbva}") String[] headers) {
        AccountingMovementServices accountingMovementServices = new AccountingMovementServices();
        accountingMovementServices.setHeaders(headers);
        accountingMovementServices.setAccountingMovementFactory(bbvaFactory);
        return accountingMovementServices;
    }
}
