package com.company;

import java.util.Scanner;

//Пользователь вводит n, вывести на экран факториал введенного числа

public class Homework02Task03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int resultat = 1;
        for (int i = 1; i <= k; i++){
            resultat = resultat * i;
        }
        System.out.println(resultat);

    }

}
