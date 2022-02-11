package tests;

import java.util.Scanner;
//Вводится число и выводится сообщение является ли это число степенью числа два

public class Test18IfNumberDegreeOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if ( degreeOfTwo(n) == 1) System.out.println("YES");
        else System.out.println("NO");
    }
    public static int degreeOfTwo (int a) {
        if (a >= 1) {
            if (a % 2 == 0) {
                return degreeOfTwo(a / 2);
            } else if (a == 1) {
                return 1;
            } else return - 1;

        } else return - 1;
    }
}
