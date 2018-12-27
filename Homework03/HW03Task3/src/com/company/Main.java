package com.company;
import java.util.Scanner;

//Локальный максимум - элемент, который больше предыдущего и следующего.
// Подсчитать, сколько локальных максимумов во введенном с клавиатуры массиве.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int k = sc.nextInt();

        int number = 0; //количество локальных максимумов
        int[] arr = new int[k];

        System.out.println("Введите числа: ");
        for (int i = 0; i < k; i++) {

            arr[i] = sc.nextInt();
        } //заполнение массива числами

        for (int i = 0; i < k ; i++) {

            if (i > 0 && i < k-1 && arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                number++;
            } //нахождение локального максимума
        }
        System.out.println("Количество локальных максимумов:" + " " + number);
    }
}
