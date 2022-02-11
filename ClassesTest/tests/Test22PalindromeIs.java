package tests;

import java.util.Scanner;
//Определяет является ли строка палиндромом

public class Test22PalindromeIs {
    public static boolean palindrom = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (task(0, str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean task (int index, String str) {
        if (index < str.length() / 2 ) {
            if (str.charAt(index) == str.charAt(str.length() - 1 - index) && palindrom == true ) {
                task (index += 1, str);
            } else {
                palindrom = false;
            }
        }
        return palindrom;
    }
}
