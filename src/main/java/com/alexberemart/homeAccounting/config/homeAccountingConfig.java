package com.alexberemart.homeAccounting.config;

import com.alexberemart.homeAccounting.factories.AccountingMovementFactory;
import com.alexberemart.homeAccounting.factories.BbvaFactory;
import com.alexberemart.homeAccounting.factories.CsvFactory;
import com.alexberemart.homeAccounting.factories.IngFactory;
import com.alexberemart.homeAccounting.services.AccountingMovementServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class HomeAccountingConfig {

    @Bean()
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
        AlexberemartPropertyPlaceholderConfigurer alexberemartPropertyPlaceholderConfigurer = new AlexberemartPropertyPlaceholderConfigurer();
        alexberemartPropertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        alexberemartPropertyPlaceholderConfigurer.setOrder(0);

        List<Resource> resourceList = new ArrayList<Resource>();
        resourceList.add(new ClassPathResource("com/alexberemart/homeAccounting/context.properties"));
        resourceList.add(new ClassPathResource("data/jdbc-dev.properties"));

        alexberemartPropertyPlaceholderConfigurer.setLocations(resourceList.toArray(new Resource[]{}));
        return alexberemartPropertyPlaceholderConfigurer;
    }

    @Bean("ingFactory")
    public IngFactory getIngFactory() {
        return new IngFactory();
    }

    @Bean("bbvaFactory")
    public BbvaFactory getBbvaFactory() {
        return new BbvaFactory();
    }

    @Bean("ingCsvFactory")
    public CsvFactory getIngCsvFactory(@Value("${headers.ing}") String[] headers) {
        CsvFactory csvFactory = new CsvFactory();
        csvFactory.setHeaders(headers);
        return csvFactory;
    }

    @Bean("bbvaCsvFactory")
    public CsvFactory getBbvaCsvFactory(@Value("${headers.bbva}") String[] headers) {
        CsvFactory csvFactory = new CsvFactory();
        csvFactory.setHeaders(headers);
        return csvFactory;
    }

    @Bean("ingAccountingMovementServices")
    public AccountingMovementServices getIngAccountingMovementServices(
            @Value("${headers.ing}") String[] headers,
            IngFactory ingFactory,
            CsvFactory ingCsvFactory) {
        return getAccountingMovementServices(headers, ingFactory, ingCsvFactory);
    }

    @Bean("bbvaAccountingMovementServices")
    public AccountingMovementServices getBbvaAccountingMovementServices(
            @Value("${headers.bbva}") String[] headers,
            BbvaFactory bbvaFactory,
            CsvFactory bbvaCsvFactory) {
        return getAccountingMovementServices(headers, bbvaFactory, bbvaCsvFactory);
    }

    private AccountingMovementServices getAccountingMovementServices(String[] headers, AccountingMovementFactory accountingMovementFactory, CsvFactory csvFactory) {
        AccountingMovementServices accountingMovementServices = new AccountingMovementServices();
        accountingMovementServices.setAccountingMovementFactory(accountingMovementFactory);
        accountingMovementServices.setCsvFactory(csvFactory);
        return accountingMovementServices;
    }
}
