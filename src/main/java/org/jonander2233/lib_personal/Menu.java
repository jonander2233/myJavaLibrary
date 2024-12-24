package org.jonander2233.lib_personal;
import org.jonander2233.Lang;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
public class Menu {
    private static Locale locale; // Idioma por defecto del sistema
    private static ResourceBundle mensajes = ResourceBundle.getBundle("messages", locale);

    public Menu(Lang language) {
        locale = new Locale(language.getLang(), language.getCountry());
    }

    public int show(String titulo, String[] opciones,String textoFinal){
        int opcion;
        do {
            System.out.println("*********************");
            System.out.println("****" + titulo + "****");
            System.out.println("*********************");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println(i + 1 + "." + opciones[i]);
            }
            System.out.println("-----------------------");
            System.out.println("0."+textoFinal);
            opcion = validarOpcion();
            if (opcion < 0 || opcion > opciones.length) {
                System.out.println(mensajes.getString("num_invalido_err"));
            }
        }while (opcion < 0 || opcion > opciones.length);
        return opcion;
    }
    public static int show(String titulo, String[] opciones){
        int opcion;
        do {
            System.out.println("***************************************");
            System.out.println("****" + titulo + "****");
            System.out.println("***************************************");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println(i + 1 + "." + opciones[i]);
            }
            System.out.println("-----------------------");
            opcion = validarOpcion();

            if (opcion < 1 || opcion > opciones.length) {
                System.out.println(mensajes.getString("num_invalido_err"));
            }

        }while (opcion < 1 || opcion > opciones.length);
        return opcion;
    }

    private static int validarOpcion(){
        Scanner scanner = new Scanner(System.in);
        int numero=0;
        boolean valido=false;
        do {
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                valido = true;
            } else {
                System.out.println(mensajes.getString("int_num_err"));
                scanner.next();
            }
        }while (!valido);
        return numero;
    }

}