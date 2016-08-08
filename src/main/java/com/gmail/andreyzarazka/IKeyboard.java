package com.gmail.andreyzarazka;

import java.util.InputMismatchException;

public interface IKeyboard {

    String getKbdString();

    int getKbdInt() throws InputMismatchException;
}
