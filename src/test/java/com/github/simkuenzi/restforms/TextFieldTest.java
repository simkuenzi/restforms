package com.github.simkuenzi.restforms;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import static org.junit.Assert.*;

public class TextFieldTest {

    private TextField field;

    @Before
    public void setUp() {
        MultivaluedMap<String, String> form = new MultivaluedHashMap<>();
        form.putSingle("fieldName", "Hello");
        field = new TextField("fieldName", form);
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
        assertEquals("", field.getMessage());
    }

    @Test
    public void testToString() {
        assertEquals("Hello", field.toString());
    }
}