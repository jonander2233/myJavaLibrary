package org.jonander2233.lib_personal;

public class Pila {
    private String[] datos;
    private int indice;

    public Pila(int capacidadInicial) {
        datos = new String[capacidadInicial];
        indice = -1;
    }

    public void push(String elemento) {
        if(isFull()) {
            ampliarArray();
        }
        datos[++indice] = elemento;
    }

    public String pop() {
        if(isEmpty()) {
            return null;
        }
        return datos[indice--];
    }

    private boolean isFull() {
        return indice == datos.length - 1;
    }

    public int size() {
        return indice + 1;
    }

    public String top() {
        if(isEmpty()) {
            return null;
        }
        return datos[indice];
    }

    public boolean isEmpty() {
        return indice == -1;
    }

    private void ampliarArray() {
        String[] nuevoArray = new String[datos.length * 2];
        for(int i = 0; i < datos.length; i++) {
            nuevoArray[i] = datos[i];
        }
        datos = nuevoArray;
    }
}