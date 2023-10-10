import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введіть кількість рядків матриці: ");
        int n;
        try {
            n = in.nextInt();
            if (n <= 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.print("Кількість рядків повинна бути натуральним числом");
            return;
        }

        System.out.print("Введіть кількість стовпців матриці: ");
        int m;
        try {
            m = in.nextInt();
            if (m <= 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.print("Кількість стовпців повинна бути натуральним числом");
            return;
        }
        int[][] A = new int[n][m];
        generateRandomMatrix(A);
        int[][] B = new int[n][m];
        generateRandomMatrix(B);
        System.out.println("Матриця A");
        outputMatrix(A);
        System.out.println("Матриця B");
        outputMatrix(B);
        int[][] C = new int[n][m];
        matrixXOR(A, B, C);
        System.out.println("Матриця C");
        outputMatrix(C);
        System.out.println("Сума найменших елементів по стовпцях - " + sumOfSmallestElementsInColumns(C));


    }

    static void generateRandomMatrix(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Генеруємо випадкове число від 0 до 100(не включно) (можете змінити діапазон за потребою)
                matrix[i][j] = random.nextInt(100);
            }
        }

    }

    static void outputMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");

            }
            System.out.println();
        }

    }

    static void matrixXOR(int[][] matrixA, int[][] matrixB, int[][] matrixC) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixC[i][j] = matrixA[i][j] ^ matrixB[i][j];
            }
        }
    }

    public static int sumOfSmallestElementsInColumns(int[][] matrix) {
        int sum = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            int min = matrix[0][j];

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }

            sum += min;
        }

        return sum;
    }
}