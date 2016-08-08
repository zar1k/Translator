package com.gmail.andreyzarazka;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Translator implements ITranslator {
    private final String DEFAULT_PATH = "src\\main\\resources\\dictionaries\\";

    private Map<String, String> currentDictionary = new HashMap<>();

    @Override
    public List<File> getDictionaries() throws FileNotFoundException {
        final File DEFAULT_DIR = new File(DEFAULT_PATH);
        File[] dictionaries = null;
        List<File> result = new ArrayList<>();

        if (!DEFAULT_DIR.exists()) {
            throw new FileNotFoundException();
        }
        if (DEFAULT_DIR.isDirectory()) {
            dictionaries = DEFAULT_DIR.listFiles();
            for (File fileName : dictionaries) {
                result.add(fileName);
            }
        }
        return result;
    }

    @Override
    public void choiceDictionary(int value) throws IndexOutOfBoundsException, IOException {
        List<File> dictionaries = getDictionaries();
        int index = value;
        String absolutePath = dictionaries.get(index).getAbsolutePath();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(absolutePath)))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty())
                    continue;

                if (line.startsWith("#"))
                    continue;

                String tok[] = line.split("=");
                if (tok.length != 2) {
                } else {
                    currentDictionary.put(tok[0].trim(), tok[1].trim());
                }
            }
        }
    }

    @Override
    public String translate(String path) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String tok[] = line.split("[,;:.!? ]+");
                for (String word : tok) {

                    if (currentDictionary.containsKey(word)) {
                        String translatedWord = currentDictionary.get(word);
                        sb.append(translatedWord).append(" ");
                    } else {
                        sb.append("[ ").append(word).append(" ]").append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        currentDictionary.clear();
        return sb.toString();
    }
}
