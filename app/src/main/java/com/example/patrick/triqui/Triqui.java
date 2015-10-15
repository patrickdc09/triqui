package com.example.patrick.triqui;

/**
 * Created by cristiangomez on 14/10/15.
 */
public class Triqui {

    private int[][] tablero;
    private boolean activo;

    public Triqui() {
        tablero = new int[3][3];
        activo = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = 0;
            }
        }

    }

    public void marcar(int marca, int i, int j) {
        tablero[i][j] = marca;
    }

    public boolean estaMarcada(int i, int j) {
        if (tablero[i][j] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public int hayganador() {
        int valorFila0 = chequearFila(0);

        if (valorFila0 != 0) {
            activo = false;
            return valorFila0;
        }

        int valorFila1 = chequearFila(1);

        if (valorFila1 != 0) {
            activo = false;
            return valorFila1;
        }

        int valorFila2 = chequearFila(2);

        if (valorFila2 != 0) {
            activo = false;
            return valorFila2;
        }

        int valorColumna0 = chequearColumna(0);

        if (valorColumna0 != 0) {
            activo = false;
            return valorColumna0;
        }

        int valorColumna1 = chequearColumna(1);

        if (valorColumna1 != 0) {
            activo = false;
            return valorColumna1;
        }

        int valorColumna2 = chequearColumna(2);

        if (valorColumna2 != 0) {
            activo = false;
            return valorColumna2;
        }

        int valorDiagonal1 = chequearDiagonal1();
        if (valorDiagonal1 != 0) {
            activo = false;
            return valorDiagonal1;
        }

        int valorDiagonal2 = chequearDiagonal2();
        if (valorDiagonal2 != 0) {
            activo = false;
            return valorDiagonal2;
        }

        return 0;
    }

    private int chequearFila(int i) {
        if (tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
            return tablero[i][0];
        }
        return 0;
    }

    private int chequearColumna(int i) {
        if (tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
            return tablero[0][i];
        }
        return 0;
    }

    private int chequearDiagonal1() {

        if (tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return tablero[0][0];
        }
        return 0;
    }

    private int chequearDiagonal2() {

        if (tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return tablero[0][2];
        }
        return 0;
    }

    public boolean esActivo() {
        return activo;
    }
}
