package com.company;
import java.util.Scanner;


//Пользователь вводит n, подсчитать и вывести сумму цифр числа n.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int sum = 0;
        while (k > 0) {
            sum = sum +(k%10);
            k = k/10;
        }
        System.out.print(sum);
    }
}
