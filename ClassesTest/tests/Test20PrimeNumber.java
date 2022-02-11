package tests;

import java.util.Scanner;

public class Test20PrimeNumber {
    public static boolean flag = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (task(2, n)) System.out.println("YES");
            else System.out.println("NO");
    }
    public static boolean task (int divider, int a) {
        if (a > 1) {
            if (divider < a / 2) {
                if (a % divider == 0) {
                    System.out.println(divider);
                    flag = false;
                }
                else {
                    task(divider += 1, a);
                }
            }
            return flag;
        }
        return false;
    }

}
