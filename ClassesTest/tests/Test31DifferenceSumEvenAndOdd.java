package tests;

import java.util.Scanner;

/** Пользователь вводит сначала n (кол-во чисел), затем последовательно n чисел.
 * Вычислить разность между суммой всех четных чисел из последовательности и суммой всех нечетных.
 */

public class Test31DifferenceSumEvenAndOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        differenceSumEvenAndOdd(array);
    }
    public static void differenceSumEvenAndOdd (int[] array) {
        Scanner sc = new Scanner(System.in);
        int sumEven = 0, sumOdd = 0, result = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            if (array[i] % 2 == 0) {
                sumEven += array[i];
            }
            if (array[i] % 2 != 0) {
                sumOdd += array[i];
            }
        }

        result = Math.abs(Math.abs(sumEven) - Math.abs(sumOdd));

        System.out.println("Difference: " + result);
    }
}
