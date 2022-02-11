package tests;
//Развернуть эл-ты в массиве относительно центра: {3, 2, 1, 4} → {4, 1, 2, 3}

import java.util.Scanner;

public class Test08ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < n/2; i++){
            int a = numbers[i];
            numbers[i] = numbers[n-i-1];
            numbers[n-i-1] = a;
        }
        for (int i = 0; i < n; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}
