package com.company;
import java.util.Scanner;

//Есть массив вида {3, 4, 2, 11, 133}. Получить int x, равный 34211133

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int n = sc.nextInt();

        System.out.println("Введите числа:");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } //заполнение массива


        String str = ""; //инициализация строки, в которую будут записываться числа

        for (int i = 0; i < n; i++) {
            str = str + arr [i];
        }

        System.out.println("Ваше число:" + " " + Integer.parseInt(str));

    }
}
