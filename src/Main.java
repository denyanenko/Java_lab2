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
        float[][] A = new float[n][m];
        generateRandomMatrix(A);
        float[][] B = new float[n][m];
        generateRandomMatrix(B);
        System.out.println("Матриця A");
        outputMatrix(A);
        System.out.println("Матриця B");
        outputMatrix(B);
        float[][] C;
        try {
            C = matrixXOR(A, B);
            System.out.println("Матриця C");
            outputMatrix(C);
            System.out.println("Сума найменших елементів по стовпцях - " + sumOfSmallestElementsInColumns(C));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    static void generateRandomMatrix(float[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Генеруємо випадкове число від 0 до 100(не включно) (можете змінити діапазон за потребою)
                matrix[i][j] = random.nextInt(100);
            }
        }

    }

    static void outputMatrix(float[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.0f\t", matrix[i][j]);

            }
            System.out.println();
        }

    }

    static float[][] matrixXOR(float[][] matrixA, float[][] matrixB) throws Exception {
        if (matrixA.length != matrixB.length) {
            throw new Exception("Різна кількість рядків в вхідних матрицях");
        }
        if (matrixA[0].length != matrixB[0].length) {
            throw new Exception("Різна кількість стовпців в вхідних матрицях");
        }
        for (int i = 1; i < matrixA.length; i++) {
            if (matrixA[0].length != matrixA[i].length) {
                throw new Exception("Матриця А не прямокутна");
            }
            if (matrixB[0].length != matrixB[i].length) {
                throw new Exception("Матриця B не прямокутна");
            }

        }
        float[][] matrixC = new float[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixC[i][j] = (int) matrixA[i][j] ^ (int) matrixB[i][j];
            }
        }
        return matrixC;
    }

    public static float sumOfSmallestElementsInColumns(float[][] matrix) throws Exception {
        float sum = 0;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[0].length != matrix[i].length) {
                throw new Exception("Матриця не прямокутна");
            }

        }

        for (int j = 0; j < matrix[0].length; j++) {
            float min = matrix[0][j];

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