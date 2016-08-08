package com.gmail.andreyzarazka;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

/*
 * Тестовые файлы:
 * 	1. en_file.txt
 * 	2. ru_file.txt
 * 	3. ua_file.txt
 * лежат в корне проекта
 */
public class Show {
    public static void main(String[] args) {
        final int EXIT = 9;
        int index = 0;
        Integer value = null;

        ITranslator translator = new Translator();
        IKeyboard keyboard = new Keyboard();
        Logger logger = Logger.getLogger(Show.class);

        System.out.println("============== TRANSLATE =============");

        try {
            List<File> files = translator.getDictionaries();
            System.out.println("Выберете направление перевода:");

            for (File file : files) {
                String name = file.getName().substring(0, 5);
                System.out.printf("%24s %10s %d\n", name, "введите", index++);
            }

            System.out.println("--------------------------------------");
            System.out.printf("%-20s %s\n", "Выйти с программы TRANSLATE", "введите 9");
            System.out.println("--------------------------------------");
            System.out.println("======================================");
        } catch (FileNotFoundException e) {
            System.out.println("--------------------------------------");
            System.out.println("ПРЕДУПРЕЖДЕНИЕ: Отсутствуют словари");
            logger.error("Отсутствуют словари");
            System.exit(EXIT);
        }
        while (true) {
            System.out.printf("\n%s", "Ваш выбор:");
            try {
                value = keyboard.getKbdInt();

                if (value.equals(EXIT)) {
                    System.out.println("TRANSLATE завершил работу");
                    System.exit(EXIT);
                }
                try {
                    translator.choiceDictionary(value);
                } catch (IndexOutOfBoundsException e) {
                    logger.error("Отсутствует словарь по данному индексу [" + value + "]. Метод \"choiceDictionary(int value)\"");
                }

                switch (value) {
                    case 0:
                        System.out.print("Укажите путь к файлу, который нужно перевести: ");
                        System.out.println("> " + translator.translate(keyboard.getKbdString()));
                        break;
                    case 1:
                        System.out.print("Укажите путь к файлу, который нужно перевести: ");
                        System.out.println("> " + translator.translate(keyboard.getKbdString()));
                        break;
                    case 2:
                        System.out.print("Укажите путь к файлу, который нужно перевести: ");
                        System.out.println("> " + translator.translate(keyboard.getKbdString()));
                        break;
                    case 3:
                        System.out.print("Укажите путь к файлу, который нужно перевести: ");
                        System.out.println("> " + translator.translate(keyboard.getKbdString()));
                        break;
                    case 4:
                        System.out.print("Укажите путь к файлу, который нужно перевести: ");
                        System.out.println("> " + translator.translate(keyboard.getKbdString()));
                        break;
                    case 5:
                        System.out.print("Укажите путь к файлу, который нужно перевести: ");
                        System.out.println("> " + translator.translate(keyboard.getKbdString()));
                        break;

                    default:
                        System.out.println("Отсутствует словарь по данному индексу [" + value + "]" + ".\nПовторите ввод.\n");
                        break;
                }
            } catch (InputMismatchException | IOException e) {
                System.out.println("Некорректный ввод");
                logger.error("Некорректный ввод. Метод \"getKbdInt()\"");
            }
        }
    }
}
