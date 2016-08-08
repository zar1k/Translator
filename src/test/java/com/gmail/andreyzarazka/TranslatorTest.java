package com.gmail.andreyzarazka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TranslatorTest {
    private ITranslator translator;

    @Before
    public void setUp() throws Exception {
        translator = new Translator();
    }

    @After
    public void tearDown() throws Exception {
        translator = null;
    }

    @Test
    public void testGetDictionaries() throws Exception {

    }

    @Test(expected = FileNotFoundException.class)
    public void testGetDictionariesExc() throws Exception {

    }

    @Test
    public void choiceDictionary() throws Exception {

    }

    @Test
    public void translate() throws Exception {

    }

}