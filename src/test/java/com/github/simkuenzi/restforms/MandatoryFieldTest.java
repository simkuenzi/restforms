package com.github.simkuenzi.restforms;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MandatoryFieldTest {

    private MandatoryField field;

    @Before
    public void setUp() {
        field = new MandatoryField(new FormField<String>() {
            @Override
            public String getValue() {
                return "Hello";
            }

            @Override
            public boolean isValid() {
                return true;
            }

            @Override
            public @NotNull String getMessage() {
                return "innerMessage";
            }

            @Override
            public String toString() {
                return "innerToString";
            }
        },"message");
    }

    @Test
    public void getValue() {
        assertEquals("Hello", field.getValue());
    }

    @Test
    public void isValid() {
        assertTrue(field.isValid());
    }

    @Test
    public void getMessage() {
        assertEquals("innerMessage", field.getMessage());
    }

    @Test
    public void testToString() {
        assertEquals("innerToString", field.toString());
    }
}