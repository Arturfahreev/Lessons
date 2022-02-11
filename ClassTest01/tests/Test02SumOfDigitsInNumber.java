package tests;

import java.util.Scanner;

//Пользователь вводит n, подсчитать и вывести сумму цифр числа n.

public class Test02SumOfDigitsInNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumOfDigitsInNumber(n));
    }

    public static int sumOfDigitsInNumber (int n) {
        int sum = 0;
        for (int i = 0; n > 0 ; i++) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
