package com.github.simkuenzi.restforms;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import javax.ws.rs.core.MultivaluedMap;

public class DecimalField implements FormField<BigDecimal> {

    private static final Pattern PATTERN = Pattern.compile("\\d+(\\.\\d+)?");

    private final String name;
    private final MultivaluedMap<String, String> rawForm;
    private final String message;

    public DecimalField(String name, MultivaluedMap<String, String> rawForm, String message) {
        this.name = name;
        this.rawForm = rawForm;
        this.message = message;
    }

    @Override
    public BigDecimal getValue() {
        return new BigDecimal(rawValue());
    }

    @Override
    public boolean isValid() {
        return PATTERN.matcher(rawValue()).matches();
    }

    @NotNull
    @Override
    public String getMessage() {
        return isValid() ?  "" : message;
    }

    @Override
    public String toString() {
        return rawValue();
    }

    private String rawValue() {
        return rawForm.containsKey(name) ? rawForm.getFirst(name) : "";
    }
}