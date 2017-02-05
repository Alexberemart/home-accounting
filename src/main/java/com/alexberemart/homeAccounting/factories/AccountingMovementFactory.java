package com.alexberemart.homeAccounting.factories;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.model.domain.BankAccount;
import org.apache.commons.csv.CSVRecord;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class AccountingMovementFactory {

    public Date getDateFromString(String text) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter.parse(text);
    }

    public Float getFloatFromString(String text) throws ParseException {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(symbols);
        return format.parse(text).floatValue();
    }

    public abstract AccountingMovement getAccountingMovementsFromCSVRecord(CSVRecord record, BankAccount bankAccount) throws ParseException;
    public abstract void setHeaders(String[] headers);
}
