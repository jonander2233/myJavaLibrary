package org.jonander2233.lib_personal;
import java.util.Random;

public class Arrayp {
    private static Random aleatorio = new Random();

    public static String arrayDevolverPosicionPar(char[]letras){
        StringBuilder resultado = new StringBuilder();

        for (int i=1;i<letras.length;i+=2){
            resultado.append(letras[i]);
        }
        return resultado.toString();
    }




    public static String arrayDevolverPosicionImpar(char[]letras){
        StringBuilder resultado = new StringBuilder();

        for (int i=0;i<letras.length;i+=2){
            resultado.append(letras[i]);
        }
        return resultado.toString();
    }





    //metodo para rellenar con números aleatorios un array
    public static void rellenarAleatorio (int[]arrayNumeros, int min, int max){
        for(int i=0; i< arrayNumeros.length; i++){
            arrayNumeros[i] = aleatorio.nextInt(max- min + 1) + min;
        }
    }





    //metodo para obtener multiplos de un numero (se devuelve un array nuevo con esos numeros)
    public static int[] obtenerMultiplos(int[]arrayNumeros, int multiplo){
        if (multiplo >0){

            int cantidadMultiplos=0;
            for(int numero: arrayNumeros){
                if (numero % multiplo == 0){
                    cantidadMultiplos++;
                }
            }

            int[] arrayMultiplos = new int[cantidadMultiplos];

            int posicion=0;
            for(int numero1: arrayNumeros){
                if (numero1 % multiplo == 0){
                    arrayMultiplos[posicion] = numero1;
                    posicion++;
                }
            }
            return arrayMultiplos;
        }
        else{
            return null;
        }
    }





    //metodo para obtener si un número en concreto está en el array
    public static boolean obtenerSiNumEstaEnArray (int[]arrayNumeros, int num){
        boolean resultado=false;
        int resultado1=0;
        for (int numero:arrayNumeros){
            if(num == numero){
                resultado1++;
            }else{

            }
            if (resultado1 >0){
                resultado=true;
            }
        }
        return resultado;
    }

    public static int[] ordenarBurbuja(int[] arrayNums){
        return null;
    }

    //metodo para obtener los números pares de un array de numeros enteros y su posición en el array
    public static void imprimirParesOImpares(int[]arrayNums, boolean pares){
        if (pares == true){
            for (int i =0; i<arrayNums.length; i++){
                if (arrayNums[i] % 2 == 0){
                    Eys.imprimir("par numero "+ i +" es "+ arrayNums[i] );
                }
            }
        }else if (pares == false){
            for (int i =0; i<arrayNums.length; i++){
                if (arrayNums[i] % 2 == 1){
                    Eys.imprimir("impar numero "+ i +" es "+ arrayNums[i] );
                }
            }
        }

    }
    //metodo para obtener multiplos de un numero e imprimirlos junto a su posición
    public static void imprimirMultiplos(int[]arrayNumeros, int multiplo){
        if (multiplo >0){
            for(int i=0; i<arrayNumeros.length;i++){
                if(arrayNumeros[i] % multiplo ==0){
                    Eys.imprimir("El numero "+ arrayNumeros[i]+" en la posicion "+ i +" es multiplo de "+ multiplo );
                }
            }
        }
    }


    //metodo para obtener las posiciones del array invertidas
    public static int[] devolverInverso(int[] arrayAInvertir){
        int[] arrayInvertido = new int[arrayAInvertir.length];
        int contador=0;
        for(int i = arrayAInvertir.length-1;i>=0;i--){
            arrayInvertido[contador]=arrayAInvertir[i];
            contador++;
        }
        return arrayInvertido;
    }

    //metodo para ir sumando las posiciones de un array y guardar el resultado en otro
    public static int[] sumatorio(int[]arrayASumar){
        int[] arraySumado = new int[arrayASumar.length];
        int suma = 0;
        for(int i =0;i<arrayASumar.length;i++){
            suma = suma + arrayASumar[i];
            arraySumado[i]=suma;
        }

        return arraySumado;
    }
}
