package tests;

import java.util.Scanner;
/** Локальный максимум - элемент, который больше предыдущего и следующего.
 * Подсчитать, сколько локальных максимумов во введенном с клавиатуры массиве.
 */

 public class Test05LocalMaximum {
    public static void main(String[] args) {
       System.out.println("Локальных максимумов (метод OneFor): " + localMaximumWithOneFor(arrayOfIntegerBuilder(scannerInteger())));
       System.out.println("Локальных максимумов (метод TwoFor): " + localMaximumWithTwoFor(arrayOfIntegerBuilder(scannerInteger())));
    }
    public static int [] arrayOfIntegerBuilder (int n) { //метод создаем массив из int
        int [] numbers = new int[n];
        return numbers;
    }

    public static int scannerInteger () { //метод считывает int из сканера
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число (int): ");
        int n = sc.nextInt();
        return n;
    }

    public static int localMaximumWithOneFor (int[] numbers) { //находит локальный максимум с одним for
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Введите " + numbers.length + " элементов: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt(); //Заполняем массив и сразу проводим сравнение
            if ((i >= 2) && (numbers[i - 1] > numbers[i - 2] && numbers[i - 1] > numbers[i])) {
                count++;
            }
        }
        return count;
    }

    public static int localMaximumWithTwoFor (int[] numbers) { //находит локальный максимум с двумя for
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Введите " + numbers.length + " элементов: ");

        for (int i = 0; i < numbers.length; i++) { //Сначала заполняем массив полностью
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < numbers.length; i++) { //Теперь находим локальный максимум
            if ((i > 0) && (i < numbers.length - 1) && (numbers[i] > numbers[i - 1] && numbers[i] > numbers[i + 1])) {
                count++;
            }
        }
        return count;
    }
}

