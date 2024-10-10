import java.util.Scanner;

public class ModeloExamen {
    static Scanner input = new Scanner(System.in);
    static int filas;
    static int columnas;
//    static int filas = 5;
//    static int columnas = 4;
    public static void main(String[] args) {
//        double[][] matriz = {
//                {4, 66, 78, 33},
//                {98, 65, 23, 43},
//                {12, 23, 34, 56},
//                {7, 7, 6, 66},
//                {7, 66, 6, 67}
//        };
        double[][] matriz = crearMatriz();
        cargarMatriz(matriz);
        mostrarMatriz(matriz);
        double[][] matrizSumatoria = crearMatrizSumatoria(matriz);
        mostrarMatriz(matrizSumatoria);

        double[][] matrizSumatoriaDesordenada = crearMatrizSumatoriaDesordenada(matrizSumatoria);

        mostrarMatriz(matrizSumatoriaDesordenada);

        double[][] matrizSumatoriaOrdenada = ordenarMatrizDesordenada(matrizSumatoriaDesordenada);

        mostrarMatriz(matrizSumatoriaOrdenada);

        double suma = 0.0;
        for (int i = 0; i < filas; i++) {
            suma += matrizSumatoriaOrdenada[i][0];
        }
        System.out.println("La suma es " + suma);
    }

    public static double[][] crearMatriz() {

        while (true) {
            System.out.println("Ingrese el tamanio de la matriz:");
            System.out.print("Nro de filas: ");
            filas = input.nextInt();
            System.out.print("Nro de columnas: ");
            columnas = input.nextInt();
            if (filas >= 3 && columnas >= 2) {
                break;
            } else {
                System.out.println("Fuera de rango");
            }
        }
        return new double[filas][columnas];
    }

    public static void cargarMatriz(double[][] matriz) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor de la posición [" + i + "][" + j + "]: " );
                matriz[i][j] = input.nextDouble();
            }
        }
    }

    public static void mostrarMatriz(double[][] matriz) {
        System.out.println("---MATRIZ---");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] crearMatrizSumatoria(double[][] matriz) {
        double[][] matrizSumatoria = new double[filas][1];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizSumatoria[i][0] += matriz[i][j];
            }
        }
        return matrizSumatoria;
    }

    public static double[][] crearMatrizSumatoriaDesordenada(double[][] matrizSumatoria) {
        double[][] matrizSumatoriaDesordenada = new double[filas][2];
        for (int i = 0; i < filas; i++) {
            matrizSumatoriaDesordenada[i][0] = matrizSumatoria[i][0];
            matrizSumatoriaDesordenada[i][1] = i + 1;
        }
        return matrizSumatoriaDesordenada;
    }

    public static double[][] ordenarMatrizDesordenada(double[][] matriz) {
        int n = filas;
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 1; i < n; i++) {
                if (matriz[i - 1][0] < matriz[i][0]) {
                    for (int j = 0; j < 2; j++) {
                        double aux = matriz[i - 1][j];
                        matriz[i - 1][j] = matriz[i][j];
                        matriz[i][j] = aux;
                        intercambiado = true;
                    }
                }
            }
        } while (intercambiado);
        return matriz;
    }
}