package com.github.simkuenzi.restforms;

import org.jetbrains.annotations.NotNull;

public interface FormField<T> {
    T getValue();
    boolean isValid();
    @NotNull String getMessage();
}