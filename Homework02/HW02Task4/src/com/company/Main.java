package com.company;
import java.util.Scanner;

//Пользователь вводит сначала n (кол-во чисел), затем последовательно n чисел.
// Вычислить разность между суммой всех четных чисел из последовательности и суммой всех нечетных.


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < k; i++){
            int x = sc.nextInt();
            if(x%2 == 0) {
                sum1 = sum1 + x;
            } else {
                sum2 = sum2 + x;
            }
        }
        System.out.println(Math.abs(sum1 - sum2));
    }

    }

