package com.company;

//Вывести индекс максимального по модулю элемента в массиве.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество чисел: ");

        int k = sc.nextInt();
        System.out.println("Введите числа:");

        int[] arr = new int[k];
        int max = 0; //максимальное число
        int maxIndex = 0; //индекс максимального числа

        for (int i = 0; i < k; i++){

            arr[i] = sc.nextInt();

            if (Math.abs (arr[i]) > max){
                max = Math.abs(arr[i]);
                maxIndex = i;
            }
        }
        System.out.println("Индекс максимального по модулю числа:" + " " + maxIndex);
    }
}