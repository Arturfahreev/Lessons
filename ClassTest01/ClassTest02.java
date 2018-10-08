package com.company;
//Фахреев А.Р. гр.11-806, Вариант 1, задание 2
//Не совсем понял как решать эту задачу через рекурсию и булевую.
//Дается тяжко такого рода задачи, пытаюсь разобраться.
//Можно позже спустя какое-то количество занятий, снова попробовать написать эту контрольную?
import java.util.Scanner;

public class ClassTest02 {

    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char[] arr = Palindrom(str);

    static char[] Palindrom(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < (arr.length + 1) / 2; i++) {
            if (arr[i + 1] == arr[arr.length - i - 1]) arr[i] += ' ';
        }
        return arr;
    }

    public static boolean PalindromBoolean(char[] arr, int it) {
        if ((it - 1) == (arr.length / 2)) return arr[it] == arr[arr.length - (it) - 2];
        return (arr[arr.length - (it) - 1] == arr[it]) && PalindromBoolean(arr, --it);
    }
}