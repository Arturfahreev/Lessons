package com.company;
import java.util.Scanner;

//Проверить, что эл-ты массива имеют вид a1 ≤ … ≤ ax-1 ≤ ax ≥ ax+1 ≥ … ≥ an;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество чисел:");
        int n = sc.nextInt();

        if (n % 2 == 1) {

            System.out.println("Введите числа:");
            int [] arr = new int[n];

            for (int i = 0; i < n ; i++) {
                arr[i] = sc.nextInt();
            } //заполнение массива

            int center = n/2; //индекс центрального элемента
            int count = 0; //подсчет совпадений в первой половине массива
            int count2 = 0; //подсчет совпадений во второй половине массива



            for (int i = 0; i < center ; i++) {
                if (arr[i] <= arr[i + 1]) {
                    count++;
                }
            } //цикл перебирает элементы в первой половине массива

            for (int i = n - 1; i > center; i--) {
                if (arr[i] <= arr[i - 1]) {
                    count2++;
                }

            } //цикл перебирает элементы во второй половине массива


            if (count == center && count2 == center) {
                System.out.println("Массив соответствует заданным требованиям");

            } else {
                System.out.println("Массив не соответствует заданным требованиям");
            }

        } else { //если количество элементов в массиве четное, то по центру не будет единственного ax

            System.out.println("Массив не соответствует заданным требованиям");

        }








    }
}
