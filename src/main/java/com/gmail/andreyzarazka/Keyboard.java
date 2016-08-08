package com.gmail.andreyzarazka;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Keyboard implements IKeyboard {

    @Override
    public String getKbdString() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    @Override
    public int getKbdInt() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
