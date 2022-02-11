package tests;

import java.util.Scanner;
//Считается сумма цифр числа и выводится цифры отдельно
public class Test19ToSumDigitsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumV1(n));
        sumV2(n);
    }
    public static int sumV1 (int a) {
        if (a > 0) {
            return ( (a % 10) + sumV1 (a / 10) );
        } else return 0;
    }
    public static void sumV2 (int a) {
        if (a >= 1) {
            System.out.print(a % 10 + " ");
            sumV2(a / 10);
        }
    }
}
