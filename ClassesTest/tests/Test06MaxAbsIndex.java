package tests;

import java.util.Scanner;
//Находит максимальное число в массиве и выдает его индекс
public class Test06MaxAbsIndex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int max = Integer.MIN_VALUE, index = 0;

        for (int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();

            if (Math.abs(numbers[i]) > max) {
                max = Math.abs(numbers[i]);
                index = i;
            }
        }
        System.out.println("max: " + max);
        System.out.println("index: " + index);

    }
}
