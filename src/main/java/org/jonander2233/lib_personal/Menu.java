package org.jonander2233.lib_personal;
import java.util.Scanner;
public class Menu {
    public static int mostrar(String titulo, String[] opciones,String textoFinal){
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
                System.out.println("error, el numero introducido no es valido");
            }
        }while (opcion < 0 || opcion > opciones.length);
        return opcion;
    }
    public static int mostrar(String titulo, String[] opciones){
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
                System.out.println("error, el numero introducido no es valido");
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
                System.out.println("Entrada no válida. Debe ingresar un número entero.");
                scanner.next();
            }
        }while (valido==false);
        return numero;
    }

}