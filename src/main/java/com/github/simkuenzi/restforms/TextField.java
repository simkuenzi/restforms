package com.github.simkuenzi.restforms;

import org.jetbrains.annotations.NotNull;

import javax.ws.rs.core.MultivaluedMap;

public class TextField implements FormField<String> {

    private final String name;
    private final MultivaluedMap<String, String> rawForm;

    public TextField(String name, MultivaluedMap<String, String> rawForm) {
        this.name = name;
        this.rawForm = rawForm;
    }

    @Override
    public String getValue() {
        return rawValue().trim();
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @NotNull
    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public String toString() {
        return rawValue();
    }

    @NotNull
    private String rawValue() {
        return rawForm.containsKey(name) ? rawForm.getFirst(name) : "";
    }
}
