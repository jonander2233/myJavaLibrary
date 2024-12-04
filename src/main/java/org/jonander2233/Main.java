package org.jonander2233;

import org.jonander2233.lib_personal.Eys;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Eys.cambiarIdioma("en","EN");
        Double a = Eys.imprimirYLeerDouble("a");
        System.out.println(a);
    }

}