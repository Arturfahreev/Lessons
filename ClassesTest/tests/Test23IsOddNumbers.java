package tests;

import java.util.Scanner;
//Вводятся числа, выводится строка из нечетных чисел

public class Test23IsOddNumbers {
    public static Scanner sc;
    public static String str = "";

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        task();
    }

    public static void task() {
        int a = sc.nextInt();
        if (a != 0) {
            if (a % 2 != 0) {
                str += a + " ";
            }
            task();
        } else System.out.println(str);

    }

}
