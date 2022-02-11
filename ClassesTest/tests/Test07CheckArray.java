package tests;

import java.util.Scanner;
//Проверить что элементы массива имеют вид a1 <= ... ax-1 <= ax <= ax+1 <= ... <= an

public class Test07CheckArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        boolean check = false;
        boolean flag = false;

        for (int i = 0; i < n-1; i++) {
            if (numbers[i] <= numbers[i+1] & flag == false & i < n-2) {
                check = true;
            }
            else if (numbers[i] >= numbers[i+1]) {
                flag = true;
            }
            else {
                check = false;
            }
        }
        System.out.println(check);
    }
}
