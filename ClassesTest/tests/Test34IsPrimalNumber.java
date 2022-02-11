package tests;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *    Написать программу, определяющую, является ли введённое
 *    целое число простым, т.е. делится без остатка только на 1 и само
 *    на себя.
 */

public class Test34IsPrimalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = isPrimalNumber(n);

        if (result == 0) System.out.println("Is prime");
        else System.out.println("Not prime, divider: " + result);
    }
    public static long isPrimalNumber (long n) {
        long result = 0;
        ArrayList<Integer> list1 = new ArrayList();
        for (int i = 2; i < n; i++) {
            if (n % i != 0) {
                list1.add(i);
            }
            
            if (n % i == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
