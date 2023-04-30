/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminas;

import java.util.Scanner;

public class Buscaminas {

    int minas, tablero[][], tamanio;
    boolean derrota = false;

    public Buscaminas(int dim) {
        tamanio = dim;
        minas =10;
        int a, b;
        boolean salida;
        tablero = new int[dim][dim];
        for (int i = 0; i < minas; i++) {
            salida = false;

                a = (int) (Math.random() * dim);
                b = (int) (Math.random() * dim);
                    tablero[a][b] = 1;
                    salida = true;
        }
    }

    public boolean click() {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        if (tablero[x][y] == 1) {
            derrota = true;
            System.out.println("Has perdido");
        } else {
            tablero[x][y] = 2;
            tablero();
        }
        return derrota;
    }

    public void tablero() {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (tablero[i][j] != 2) {
                    System.out.print("x ");
                } else {
                    if (alrededor(i, j) == 0) {
                        System.out.print("  ");
                    } else {
                        System.out.println(alrededor(i, j)+" ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public int alrededor(int a, int b) {
        int contador = 0;
        if (a + 1 < tablero.length) {
            if (tablero[a + 1][b] == 1) {
                contador++;
            }
        }
        if (a - 1 > -1) {
            if (tablero[a - 1][b] == 1) {
                contador++;
            }
        }
        if (b + 1 < tablero.length) {
            if (tablero[a][b + 1] == 1) {
                contador++;
            }
        }
        if (b - 1 >-1) {
            if (tablero[a][b - 1] == 1) {
                contador++;
            }
        }
        if (b + 1 < tablero.length) {
            if (a + 1 < tablero.length) {
                if (tablero[a + 1][b + 1] == 1) {
                    contador++;
                }
            }
        }
        if (b - 1 >-1) {
            if (a - 1 >-1) {
                if (tablero[a - 1][b - 1] == 1) {
                    contador++;
                }
            }
        }
        if (b + 1 < tablero.length) {
            if (a - 1 >-1) {
                if (tablero[a - 1][b + 1] == 1) {
                    contador++;
                }
            }
        }
        if (b - 1 >-1) {
            if (a + 1 < tablero.length) {
                if (tablero[a + 1][b - 1] == 1) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
