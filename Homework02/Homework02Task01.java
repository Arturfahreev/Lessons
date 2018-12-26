package com.company;
import java.util.Scanner;
//Пользователь вводит сначала n (кол-во чисел),
// затем последовательно n чисел. Вывести максимальное по модулю число
//Test1
public class Homework02Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m;
        int max = 0;
        for (int i = 0;i < k; i++) {
            int x = sc.nextInt();
            if (max < Math.abs(x)) {
                max = Math.abs(x);
            }
        }
        System.out.println(max);
    }
}

