package org.jonander2233.lib_personal;

public class MathSelf {
    public static double discount (double porcentaje,double num){
        double precioConDescuento = num - (num * (porcentaje/100));
        return precioConDescuento;
    }
}
