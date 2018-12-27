package com.company;
import java.util.Scanner;


//n студентов в группе. Вычислить средний рост в группе и количество студентов, чей рост выше среднего.
// Вводится сначала число студентов, затем по очереди рост каждого.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0; //средний рост
        int k = 0; //количество студентов выше среднего

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum = sum + a[i]; //средний рост
        }

        sum = sum/n;

        for (int i = 0; i < n; i++) {
            if(a[i] >= sum) {
                k++;
            }
        }

        System.out.println(sum);
        System.out.println(k);
    }
}
