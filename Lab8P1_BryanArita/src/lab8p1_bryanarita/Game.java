/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_bryanarita;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {

    public Scanner duki = new Scanner(System.in);
    public Random rndm = new Random();

    public void menu() {
        System.out.print("[1] Game of life\n[2]Salir del programa\nIngrese opcion: ");
        int opcion = duki.nextInt();
        int[][] matriz;
        int[][] matriz2;
        while (opcion != 2) {
            switch (opcion) {
                case 1:

                    System.out.print("Ingrese el numero de rondas: ");
                    int rondas = duki.nextInt();
                    matriz = Random();
                    System.out.println("Coordenadas del tablero inicial: ");
                    ArrayList<String> Coordenadas = lugar(matriz);

                    for (String coordenada : Coordenadas) {
                        System.out.print(coordenada);
                    }
                    System.out.println("");
                    imprimir(matriz);

                    for (int i = 0; i < rondas; i++) {
                        System.out.println("Ronda " + (i + 1));

                        matriz2 = nextGen(matriz);
                        ArrayList<String> Coordenadas2 = lugar(matriz2);
                        
                        for (String coordenada : Coordenadas2) {
                            System.out.print(coordenada);
                        }
                        System.out.println("");
                        imprimir(matriz2);

                        matriz = matriz2;
                    }
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
            }
            System.out.print("\n[1] Game of life\n[2]Salir del programa\nIngrese opcion: ");
            opcion = duki.nextInt();
        }
        System.out.println("Saliendo del programa....");

    }

    public int[][] nextGen(int[][] matriz2) {
        int[][] temporal = matriz2;
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                int cont = 0;
                int cont2 = 0;
                if (i - 1 > 0) {
                    if (j - 1 > 0) {
                        if (j + 1 <= 9) {
                            if (i + 1 <= 9) {

                                if (matriz2[i][j] == 1) {
                                    if (matriz2[i - 1][j - 1] == 1) {
                                        cont++;
                                    } else if ((matriz2[i + 1][j + 1] == 1)) {
                                        cont++;
                                    } else if ((matriz2[i + 1][j] == 1)) {
                                        cont++;
                                    } else if ((matriz2[i][j - 1] == 1)) {
                                        cont++;
                                    } else if ((matriz2[i - 1][j] == 1)) {
                                        cont++;
                                    } else if ((matriz2[i - 1][j + 1] == 1)) {
                                        cont++;
                                    } else if ((matriz2[i + 1][j - 1] == 1)) {
                                        cont++;
                                    } else if ((matriz2[i][j + 1] == 1)) {
                                        cont++;
                                    }

                                    if (cont > 2) {
                                        matriz2[i][j] = 0;
                                    } else if (cont == 2) {
                                        matriz2[i][j] = 1;
                                    } else if (cont < 2) {
                                        matriz2[i][j] = 0;
                                    } else {
                                        continue;
                                    }

                                } if (matriz2[i][j] == 0) {
                                    if (matriz2[i - 1][j - 1] == 1) {
                                        cont2++;
                                    } else if ((matriz2[i + 1][j + 1] == 1)) {
                                        cont2++;
                                    } else if ((matriz2[i + 1][j] == 1)) {
                                        cont2++;
                                    } else if ((matriz2[i][j - 1] == 1)) {
                                        cont2++;
                                    } else if ((matriz2[i - 1][j] == 1)) {
                                        cont2++;
                                    } else if ((matriz2[i - 1][j + 1] == 1)) {
                                        cont2++;
                                    } else if ((matriz2[i + 1][j - 1] == 1)) {
                                        cont2++;
                                    } else if ((matriz2[i][j + 1] == 1)) {
                                        cont2++;
                                    }
                                    if (cont2 == 3) {
                                        matriz2[i][j] = 1;
                                    } else {
                                        continue;
                                    }
                                }

                            }// cierre de if original
                        }
                    }
                }

            }// fin del for
        }
        return temporal;
    }

    public ArrayList<String> lugar(int[][] matriz) {
        ArrayList<String> Coordenadas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] == 1) {
                    String coordenada = "(" + i + ":" + j + ") ";
                    Coordenadas.add(coordenada);
                }
            }
        }

        return Coordenadas;
    }

    public int[][] llenar() {
        int[][] temporal = new int[0][0];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temporal[i][j] = rndm.nextInt(2);
                if (i == 0 || j == 0 || i == 9 || j == 9) {
                    temporal[i][j] = 0;
                }
            }
        }
        return temporal;
    }

    public void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }

    }// fin del imprimir 

    public int[][] Random() {
        int[][] temporal = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    temporal[i][j] = 0;
                } else {
                    temporal[i][j] = rndm.nextInt(2);
                }
            }
        }
        return temporal;
    }

    public int[][] matriz2() {
        int[][] temporal = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temporal[i][j] = 0;

            }
        }
        return temporal;
    }
}
