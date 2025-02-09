package org.jonander2233.lib_personal;
import org.jonander2233.Lang;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
public class Menu {
    private static Locale locale; // Idioma por defecto del sistema
    private static ResourceBundle mensajes;

    public Menu(Lang language) {
        locale = new Locale(language.getLang(), language.getCountry());
        this.mensajes = ResourceBundle.getBundle("messages", locale);

    }
    /**
     * Muestra un menu con las opciones pasadas por parametro con opcion de salir
     * @param titulo
     * @param opciones
     * @return
     */

    public int show(String titulo, String[] opciones,String textoFinal){
        int opcion;
        System.out.println("*********************");
        System.out.println("****" + titulo + "****");
        System.out.println("*********************");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(i + 1 + "." + opciones[i]);
        }
        System.out.println("-----------------------");
        System.out.println("0."+textoFinal);
        opcion = validarOpcion(0,opciones.length);
        return opcion;
    }

    /**
     * Muestra un menu con las opciones pasadas por parametro sin opcion de salir
     * @param titulo
     * @param opciones
     * @return
     */
    public int show(String titulo, String[] opciones){
        int opcion;
        System.out.println("***************************************");
        System.out.println("****" + titulo + "****");
        System.out.println("***************************************");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(i + 1 + "." + opciones[i]);
        }
        System.out.println("-----------------------");
        opcion = validarOpcion(1,opciones.length);
        return opcion;
    }

    private static int validarOpcion(int min, int max){
        Scanner scanner = new Scanner(System.in);
        int numero=0;
        boolean valido=false;
        do {
            try {
                scanner.hasNextInt();
                numero = scanner.nextInt();
                if (numero < min || numero > max) {
                    System.out.println(mensajes.getString("num_invalido_err"));
                }else {
                    valido = true;
                }
            }catch (Exception e){
                System.out.println(mensajes.getString("int_num_err"));
                scanner.next();
            }
        }while (!valido);
        return numero;
    }

}