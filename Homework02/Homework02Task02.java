package com.company;

import java.util.Scanner;

//Пользователь вводит сначала n (кол-во чисел), затем последовательно n чисел.
// Вывести два наибольших числа (первым вывести максимальное, вторым - следующее по величине).

public class Homework02Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int max = 0;
        int max1 = 0;
        for(int i =0; i < k; i++) {
            int x = sc.nextInt();
            if (max < x) {
                max1 = max;
                max = x;
            }
            if ((max1 <= x)&&(x < max)){
                max1 = x;
            }
        }

        System.out.println(max);

        System.out.println(max1);


    }
}
