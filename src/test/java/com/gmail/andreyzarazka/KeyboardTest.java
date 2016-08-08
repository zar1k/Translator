package com.gmail.andreyzarazka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

public class KeyboardTest {
    private IKeyboard keyboard;

    @Before
    public void initTest() {
        keyboard = new Keyboard();
    }

    @After
    public void afterTest() {
        keyboard = null;
    }

    @Test
    public void testGetKbdString() throws Exception {
        System.setIn(new ByteArrayInputStream("hello".getBytes()));
        assertEquals("hello", keyboard.getKbdString());
    }

    @Test
    public void testGetKbdInt() throws Exception {
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        assertEquals(10, keyboard.getKbdInt());
    }

    @Test(expected = InputMismatchException.class)
    public void testGetKbdIntExc() {
        System.setIn(new ByteArrayInputStream("1re0".getBytes()));
        assertEquals(10, keyboard.getKbdInt());
    }
}