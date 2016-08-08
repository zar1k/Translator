package com.gmail.andreyzarazka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ITranslator {

    List<File> getDictionaries() throws FileNotFoundException;

    void choiceDictionary(int value) throws IndexOutOfBoundsException, IOException;

    String translate(String path) throws IOException;
}
