package org.jonander2233.lib_personal;

import org.jonander2233.Lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Eys {
    private Scanner lector = new Scanner(System.in);
    private Locale locale;
    private ResourceBundle mensajes;
    private Menu menu;
    public Eys(Lang language) {
        locale = new Locale(language.getLang(), language.getCountry());
        this.menu = new Menu(language);
        this.mensajes = ResourceBundle.getBundle("messages", locale);
    }
    public String leer() {
        String texto = lector.nextLine();
        return texto;
    }
    // --------------------------Reales--------------------------------------------------------
    public Double imprimirYLeerDouble(String texto) {
        System.out.println(texto);
        String res = lector.nextLine();
        Double num = null;
        if(!res.isBlank()){
            num = Double.parseDouble(res);
        }
        return num;
    }

    public double leerDouble() {
        String res = lector.nextLine();
        Double num = null;
        if(!res.isBlank()){
            num = Double.parseDouble(res);
        }
        return num;
    }

    public void imprimirDouble(double num) {
        System.out.println(num);
    }

    public float imprimirYLeerFloat(String texto, int min, int max) {
        float respuesta = 0;
        boolean valido = false;
        System.out.println(texto);
        do {
            if (lector.hasNextFloat()) {
                respuesta = lector.nextFloat();
                if (respuesta >= min && respuesta <= max) {
                    valido = true;
                } else {
                    System.out.println(mensajes.getString("num_en_rango_err") + " (" + min + " - " + max + ").");
                }
            } else {
                System.out.println(mensajes.getString("num_invalido_err"));
                lector.next(); // Limpiar el buffer de entrada
            }
        } while (!valido);
        lector.nextLine();
        return respuesta;
    }
    // --------------------------Enteros--------------------------------------------------------


    public int imprimirYLeerInt(String texto, int min, int max) {
        int respuesta = 0;
        boolean valido = false;
        System.out.println(texto);
        do {
            if (lector.hasNextInt()) {
                respuesta = lector.nextInt();
                if (respuesta >= min && respuesta <= max) {
                    valido = true;
                } else {
                    System.out.println(mensajes.getString("num_en_rango_err") + " (" + min + " - " + max + ").");
                }
            } else {
                System.out.println(mensajes.getString("num_invalido_err"));
                lector.next(); // Limpiar el buffer de entrada
            }
        } while (!valido);
        lector.nextLine();
        return respuesta;
    }

    public int leerInt(int min, int max) {
        int respuesta = 0;
        boolean valido = false;
        do {
            if (lector.hasNextInt()) {
                respuesta = lector.nextInt();
                if (respuesta >= min && respuesta <= max) {
                    valido = true;
                } else {
                    System.out.println(mensajes.getString("num_en_rango_err") + " (" + min + " - " + max + ").");
                }
            } else {
                System.out.println(mensajes.getString("num_invalido_err"));
                lector.next(); // Limpiar el buffer de entrada
            }
        } while (!valido);
        lector.nextLine();
        return respuesta;
    }

    public Integer leerInt() {
        String res = lector.nextLine();
        Integer num = null;
        if(!res.isBlank()){
            num = Integer.parseInt(res);
        }
        return num;
    }

    public void imprimirInt(int num) {
        System.out.println(num);
    }

    // --------------------------Char--------------------------------------------------------
    public char leerChar() {
        String texto = lector.nextLine();
        char caracter = texto.charAt(0);
        return caracter;
    }

    public boolean ImprimirYleerCharSN(String texto) {
        char respuesta;
        boolean respuestaBool = false;
        System.out.println(texto + " " +mensajes.getString("si_no"));
        do {
            respuesta = Character.toUpperCase( this.leerChar());
            if (respuesta == mensajes.getString("si").charAt(0)) {
                respuestaBool = true;
            } else if (respuesta == mensajes.getString("no").charAt(0)) {
                respuestaBool = false;
            } else {
                System.out.println(mensajes.getString("si_no_err"));
            }
        } while (respuesta != mensajes.getString("si").charAt(0) && respuesta != mensajes.getString("no").charAt(0));
        return respuestaBool;
    }
    // --------------------------String--------------------------------------------------------

    /**
     * @param texto        texto que será el titulo del mini menu
     * @param formatoFecha formato en tipo string, ej ----> "dd-MM-yyyy"
     * @return retorna un Date
     */
    public Date imprimirYLeerDate(String texto, String formatoFecha) {
        boolean valido = false;
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
        Date fecha = null;
        do {
            try {
                String fechaString = this.imprimirYLeer(texto + mensajes.getString(" formato_fecha") + formatoFecha, 10, 10);
                fecha = formato.parse(fechaString);
                valido = true;
            } catch (ParseException e) {
                System.out.println(mensajes.getString("fecha_conversion_err") + e.getMessage());
            }
        } while (!valido);
        return fecha;
    }


    /**
     * @param texto     texto que será el titulo del mini menu
     * @param enumClass el enumerado que quieres imprimir como opciones Titulo.class
     * @param <T>
     * @return Enum Titulo
     */
    public <T extends Enum<T>> T imprimirYLeerEnum(String texto, Class<T> enumClass) {
        String[] opcionesString = new String[enumClass.getEnumConstants().length];
        for (int i = 0; i < enumClass.getEnumConstants().length; i++) {
            opcionesString[i] = enumClass.getEnumConstants()[i].toString();
        }
        int respuesta = menu.show(texto, opcionesString);
        return enumClass.getEnumConstants()[respuesta - 1];
    }


    /**
     * @param texto el texto que se va a imprimir
     * @return un Date
     */
    public Date imprimirYLeerDate(String texto) {
        String formatoFecha = "dd-MM-yyyy";
        boolean valido = false;
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
        Date fecha = null;
        do {
            try {
                String fechaString = this.imprimirYLeer(texto + mensajes.getString("formato_fecha") + formatoFecha, 10, 10);
                fecha = formato.parse(fechaString);
                valido = true;
            } catch (ParseException e) {
                System.out.println(mensajes.getString("fecha_conversion_err") + e.getMessage());
            }
        } while (!valido);
        return fecha;
    }

    public String imprimirYLeer(String texto, int min, int max) {
        String respuesta;
        do {
            System.out.println(texto);
            respuesta = lector.nextLine();
            if (respuesta.length() < min || respuesta.length() > max) {
                System.out.println(mensajes.getString("respuesta_invalida"));
            }
        } while (respuesta.length() > max || respuesta.length() < min);
        return respuesta;
    }

    public String imprimirYLeerConExclusion(String texto, int min, int max, String palabraExcluida) {
        String respuesta;
        do {
            System.out.println(texto);
            respuesta = lector.nextLine();
            if ((respuesta.length() < min || respuesta.length() > max) || respuesta.equals(palabraExcluida)) {
                System.out.println(mensajes.getString("respuesta_invalida"));
            }
        } while ((respuesta.length() > max || respuesta.length() < min) || respuesta.equals(palabraExcluida));
        return respuesta;
    }

    // --------------------------Arrays--------------------------------------------------------
    public void leerArrayChar(char[] letras) {
        for (int i = 0; i < letras.length; i++) {
            letras[i] = this.leerChar();
        }
    }

    public void leerArrayNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = this.leerInt();
        }
    }

    public void leerArrayDouble(double[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = this.leerInt();
        }
    }
}




