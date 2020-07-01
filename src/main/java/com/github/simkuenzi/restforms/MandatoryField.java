package com.github.simkuenzi.restforms;

import org.jetbrains.annotations.NotNull;

public class MandatoryField implements FormField<String> {
    private final FormField<String> inner;
    private final String message;


    public MandatoryField(FormField<String> inner, String message) {
        this.inner = inner;
        this.message = message;
    }

    @Override
    public String getValue() {
        return inner.getValue();
    }

    @Override
    public boolean isValid() {
        return !getValue().isEmpty();
    }

    @NotNull
    @Override
    public String getMessage() {
        return !isValid() ? message : inner.getMessage();
    }

    @Override
    public String toString() {
        return inner.toString();
    }
}
