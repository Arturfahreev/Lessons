package tests;

import java.util.Scanner;
/** Локальный максимум - элемент, который больше предыдущего и следующего.
 * Подсчитать, сколько локальных максимумов во введенном с клавиатуры массиве.
 * Создать отдельные методы.
 */

 public class Test01 {
    public static void main(String[] args) {
       System.out.println("Локальных максимумов (метод OneFor): " + localMaximumWithOneFor(arrIntBuilder(scanInt())));
       System.out.println("Локальных максимумов (метод TwoFor): " + localMaximumWithTwoFor(arrIntBuilder(scanInt())));
    }

    public static int scanInt () { //метод считывает int из сканера
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число (int): ");
        return sc.nextInt();
    }

    public static int [] arrIntBuilder (int n) { //метод создает массив из int элементов
        return new int[n];
    }

    public static int[] arrFillScan (int n) { //метод создает массив и заполняет его из сканера
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[n];
        System.out.println("Введите " + numbers.length + " элементов: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        return numbers;
    }

    public static String arrPrint (int[] numbers) { //метод выдает элементы массива в строке
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str += numbers[i] + " ";
        }
        return str;
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

