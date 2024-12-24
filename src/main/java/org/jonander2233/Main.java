package org.jonander2233;

import org.jonander2233.lib_personal.Eys;
import org.jonander2233.lib_personal.Menu;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Menu menu = new Menu(Lang.EN);
        menu.show("test",new String[]{"option 1", "option 2"},"exit");
    }
}