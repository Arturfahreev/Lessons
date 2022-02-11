package tests;

//Пользователь вводит n, подсчитать и вывести сумму цифр числа n.

import java.util.Scanner;

public class Test02SumOfDigitsInNumber {
    public static void main(String[] args) {
        System.out.println(sumOfDigitsInNumber());
    }

    public static int sumOfDigitsInNumber () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; n > 0 ; i++) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
