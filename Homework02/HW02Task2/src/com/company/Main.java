package com.company;

import java.util.Scanner;

//Пользователь вводит сначала n (кол-во чисел), затем последовательно n чисел.
// Вывести два наибольших числа (первым вывести максимальное, вторым - следующее по величине).

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int max = 0;
        int max2 = 0;
        for(int i = 0; i < k; i++) {
            int x = sc.nextInt();
            if (max < x) {
                max2 = max;
                max = x;
            }
            if ((max2 < x) & (x < max)){
                max2 = x;
            }
        }

        System.out.println(max);

        System.out.println(max2);


    }
}
