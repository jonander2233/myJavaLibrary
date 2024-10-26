package org.jonander2233.lib_personal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Eys {
    private static Scanner lector = new Scanner(System.in);
    public static String leer(){
        lector = new Scanner(System.in);
        String texto = lector.nextLine();
        return texto;
    }
    // --------------------------Reales--------------------------------------------------------
    public static double imprimirYLeerDouble(String texto){
        System.out.println(texto);
        double respuesta = Double.parseDouble(lector.nextLine());
        return respuesta;
    }
    public static double leerDouble(){
        double respuesta = Double.parseDouble(lector.nextLine());
        return respuesta;
    }
    public static void imprimirDouble(double num){
        System.out.println(num);
    }

    public static float imprimirYLeerFloat(String texto, int min, int max) {
        float respuesta = 0;
        boolean valido = false;
        System.out.println(texto);
        do {
            if (lector.hasNextFloat()) {
                respuesta = lector.nextFloat();
                if (respuesta >= min && respuesta <= max) {
                    valido = true;
                } else {
                    System.out.println("Por favor, introduce un número dentro del rango (" + min + " - " + max + ").");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                lector.next(); // Limpiar el buffer de entrada
            }
        } while (!valido);
        lector.nextLine();
        return respuesta;
    }
    // --------------------------Enteros--------------------------------------------------------




    public static int imprimirYLeerInt(String texto, int min, int max){
        int respuesta = 0;
        boolean valido = false;
        System.out.println(texto);
        do {
            if (lector.hasNextInt()) {
                respuesta = lector.nextInt();
                if (respuesta >= min && respuesta <= max) {
                    valido = true;
                } else {
                    System.out.println("Por favor, introduce un número dentro del rango (" + min + " - " + max + ").");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                lector.next(); // Limpiar el buffer de entrada
            }
        } while (!valido);
        lector.nextLine();
        return respuesta;
    }

    public static int leerInt(int min, int max){
        int respuesta = 0;
        boolean valido = false;
        do {
            if (lector.hasNextInt()) {
                respuesta = lector.nextInt();
                if (respuesta >= min && respuesta <= max) {
                    valido = true;
                } else {
                    System.out.println("Por favor, introduce un número dentro del rango (" + min + " - " + max + ").");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                lector.next(); // Limpiar el buffer de entrada
            }
        } while (!valido);
        lector.nextLine();
        return respuesta;
    }

    public static int leerInt(){
        int respuesta = Integer.parseInt(lector.nextLine());
        return respuesta;

    }
    public static void imprimirInt(int num){
        System.out.println(num);
    }
    // --------------------------Char--------------------------------------------------------
    public static char leerChar(){
        String texto =lector.nextLine();
        char caracter = texto.charAt(0);
        return caracter;
    }
    public static boolean ImprimirYleerCharSN(String texto){
        char respuesta;
        boolean respuestaBool=false;
        System.out.println(texto+" S/N");
        do {
            respuesta = Eys.leerChar();
            if (respuesta == 'S' || respuesta == 's') {
                respuestaBool = true;
            } else if (respuesta == 'N' || respuesta == 'n') {
                respuestaBool = false;
            } else {
                Eys.imprimir("Por favor, ingrese S o N.");
            }
        } while (respuesta != 'S' && respuesta != 's' && respuesta != 'N' && respuesta != 'n');
        return respuestaBool;
    }
    // --------------------------String--------------------------------------------------------

    /**
     *
     * @param texto texto que será el titulo del mini menu
     * @param formatoFecha formato en tipo string, ej ----> "dd-MM-yyyy"
     * @return retorna un Date
     */
    public static Date imprimirYLeerDate(String texto,String formatoFecha){
        boolean valido = false;
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
        Date fecha= null;
        do{
            try {
                String fechaString = Eys.imprimirYLeer(texto + " en formato: " + formatoFecha,10,10);
                fecha = formato.parse(fechaString);
                valido = true;
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha: " + e.getMessage());
            }
        }while (!valido);
        return fecha;
    }


    /**
     *
     * @param texto texto que será el titulo del mini menu
     * @param enumClass el enumerado que quieres imprimir como opciones Titulo.class
     * @return Enum Titulo
     * @param <T>
     */
    public static <T extends Enum<T>> T imprimirYLeerEnum(String texto,Class<T> enumClass) {
        String[] opcionesString = new String[enumClass.getEnumConstants().length];
        for (int i = 0; i < enumClass.getEnumConstants().length; i++) {
            opcionesString[i] = enumClass.getEnumConstants()[i].toString();
        }
        int respuesta = Menu.mostrar(texto,opcionesString);
        return enumClass.getEnumConstants()[respuesta-1];
    }


    /**
     * @param texto el texto que se va a imprimir
     * @return un Date
     */
    public static Date imprimirYLeerDate(String texto){
        String formatoFecha = "dd-MM-yyyy";
        boolean valido = false;
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
        Date fecha= null;
        do{
            try {
                String fechaString = Eys.imprimirYLeer(texto + " en formato: " + formatoFecha,10,10);
                fecha = formato.parse(fechaString);
                valido = true;
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha: " + e.getMessage());
            }
        }while (!valido);
        return fecha;
    }
    public static void imprimir(String texto){
        System.out.println(texto);
    }
    public static String imprimirYLeer(String texto,int min, int max){
        String respuesta;
        do {
            System.out.println(texto);
            respuesta = lector.nextLine();
            if (respuesta.length() < min || respuesta.length() > max){
                System.out.println("Respuesta invalida");
            }
        }while (respuesta.length() > max  || respuesta.length() < min );
        return respuesta;
    }
    public static String imprimirYLeerConExclusion(String texto,int min, int max,String palabraExcluida){
        String respuesta;
        do {
            System.out.println(texto);
            respuesta = lector.nextLine();
            if ((respuesta.length() < min || respuesta.length() > max) || respuesta.equals(palabraExcluida)){
                System.out.println("Respuesta invalida");
            }
        }while ((respuesta.length() > max  || respuesta.length() < min) || respuesta.equals(palabraExcluida));
        return respuesta;
    }
    // --------------------------Arrays--------------------------------------------------------
    public static void leerArrayChar(char[] letras){
        for (int i=0; i<letras.length;i++){
            letras[i] = Eys.leerChar();
        }
    }
    public static void leerArrayNum(int[]nums){
        for (int i=0; i < nums.length ;i++){
            nums[i] = Eys.leerInt();
        }
    }
    public static void leerArrayDouble(double[]nums){
        for (int i=0; i < nums.length ;i++){
            nums[i] = Eys.leerInt();
        }
    }
    public static void imprimirArrayEnteros (int[]arrayInt){
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println("Elemento " + i + ": " + arrayInt[i]);
        }
    }

    public static int imprimirMenu4 (String opcion1,String opcion2,String opcion3,String opcion4){
        int opcion =0;
        Eys.imprimir("MENU PRINCIPAL \n ========================");
        Eys.imprimir("1.-"+opcion1);
        Eys.imprimir("2.-"+opcion2);
        Eys.imprimir("3.-"+opcion3);
        Eys.imprimir("4.-"+opcion4);
        Eys.imprimir("0.-Salir del menu.");
        opcion = Eys.imprimirYLeerInt("Selecciona una opcion: \n",0,4);
        return opcion;
    }




//comentario
// variable = Integer.parseint(lector.nextLine());
// variable = Double.parseDouble(lector.nextLine());
}
