package com.alexberemart.homeAccounting.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Bank {

    BBVA(0, "Bbva"),
    ING(1, "Ing Direct");

    protected Integer value;
    protected String description;

    Bank(Integer code, String description) {
        this.value = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static Bank parse(Integer id) {
        Bank documentType = null; // Default
        for (Bank item : Bank.values()) {
            if (item.getValue().equals(id)) {
                documentType = item;
                break;
            }
        }
        return documentType;
    }

    public static Map asMap() {
        Bank[] values = Bank.values();
        Map<Integer, String> result = new HashMap<>();
        for (Bank value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }
        return result;
    }

}
