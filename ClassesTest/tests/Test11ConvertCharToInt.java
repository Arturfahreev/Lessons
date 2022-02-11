package tests;

import java.util.Scanner;
//Вводимое число считывается как строка, преобразуется в массив char и преобразуется обратно в int

public class Test11ConvertCharToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        char [] chars = number.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length ; i++) {
            result += Math.pow(10, chars.length - i - 1) * (chars[i] - '0');
        }
        System.out.println(result);
    }
}
