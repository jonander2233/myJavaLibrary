package org.jonander2233.lib_personal;
import java.util.Random;
public class Matrices {
    public static void rellenarMatrizWithRandomNumbers (int[][] matriz, int min, int max){
        Random aleatorio = new Random();
        // int[][] matriz = new int[4][8];
        for(int x = 0; x < matriz.length; x ++){
            for(int y = 0; y < matriz[x].length; y ++){
                matriz[x][y] = aleatorio.nextInt(max - min + 1) +min;
            }
        }
    }
    public static void imprimirMatriz (int [][] matriz){
        for(int x = 0; x < matriz.length; x ++){
            for(int y = 0; y < matriz[x].length; y ++){
                System.out.print(matriz[x][y]+" ");
            }
            System.out.println("\n");
        }
    }
}
