package com.company;
import java.util.Scanner;

//Развернуть эл-ты в массиве относительно центра: {3, 2, 1, 4} → {4, 1, 2, 3}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int n = sc.nextInt();

        System.out.println("Введите числа:");
        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
        } //заполнение массива

        for (int i = 0; i < n/2; i++) {
            int a = number[i];
            number[i] = number[n-i-1];
            number[n-i-1] = a;
        } //замена элементов массива относительно центра

        for (int i = 0; i < n; i++) {
            System.out.print(number[i] + " ");
        }
    }

}
