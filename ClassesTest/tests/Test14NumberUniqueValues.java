package tests;

import java.util.Scanner;
//Вводятся два массива чисел, выдается количество уникальных элементов
public class Test14NumberUniqueValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] numbersA = new int[a];
        int[] numbersB = new int[b];
        int count = 0;

        for (int i = 0; i < numbersA.length; i++) {
            numbersA[i] = sc.nextInt();
        }
        for (int i = 0; i < numbersB.length; i++) {
            numbersB[i] = sc.nextInt();
        }

        for (int i = 0; i < numbersA.length; i++) {
            for (int j = 0; j < numbersB.length; j++) {
                if (numbersA[i] == numbersB[j]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("Уникальных элементов: " + (a + b - (2 * count)));

    }
}
