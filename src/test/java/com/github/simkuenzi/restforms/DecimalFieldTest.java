package com.github.simkuenzi.restforms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DecimalFieldTest {

    private DecimalField field;

    @Before
    public void setUp() {
        MultivaluedMap<String, String> form = new MultivaluedHashMap<>();
        form.putSingle("fieldName", "12.345");
        field = new DecimalField("fieldName", form, "message");
    }

    @Test
    public void getValue() {
        assertEquals(BigDecimal.valueOf(12.345), field.getValue());
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
        assertEquals("12.345", field.toString());
    }
}