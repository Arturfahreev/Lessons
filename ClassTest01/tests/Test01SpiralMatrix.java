package tests;

import java.util.Scanner;
public class Test01SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введение число N: ");
        int n = sc.nextInt();
        System.out.println("Введите числа(в количестве n*n): ");
        int[] arr = new int[n * n];
        for (int i = 0; i < n * n + 1; i++) {
            arr[i] = sc.nextInt();

        }
    }

    public static void sortArr(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[j]) > Math.abs(arr[j + 1])) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    System.out.print(arr[i] + "  ");
                }
            }
        }
    }

    public static void spiralFill(int[][] matrix) {
        int n = matrix.length;
        int count = 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                matrix[i][j] = count++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                matrix[j][n - 1 - i] = count++;
            }
            for (int j = n - 1 - i; j > i; j--) {
                matrix[n - 1 - i][j] = count++;
            }
            for (int j = n - 1 - i; j > i; j--) {
                matrix[j][i] = count++;
            }
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = count;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
        }
    }
}
