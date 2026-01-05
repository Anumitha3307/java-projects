package week6;

import java.util.Random;

class MatrixMultiplication implements Runnable {
    private int row;
    private int[][] A, B, C;

    public MatrixMultiplication(int row, int[][] A, int[][] B, int[][] C) {
        this.row = row;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void run() {
        int cols = B[0].length;
        for (int j = 0; j < cols; j++) {
            C[row][j] = 0;
            for (int k = 0; k < A[0].length; k++) {
                C[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

public class MatrixMultiply {
    public static void main(String[] args) {
        int size = 3; // Define matrix size
        int[][] A = new int[size][size];
        int[][] B = new int[size][size];
        int[][] C = new int[size][size];

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                A[i][j] = rand.nextInt(10);
                B[i][j] = rand.nextInt(10);
            }
        }

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);

        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(new MatrixMultiplication(i, A, B, C));
            threads[i].start();
        }

        for (int i = 0; i < size; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Result Matrix C:");
        printMatrix(C);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

