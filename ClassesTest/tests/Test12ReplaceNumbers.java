package tests;

import java.util.Scanner;
//Вводится строка и все цифры меняются на символ *
public class Test12ReplaceNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        str = "";
        for (int i = 0; i < chars.length; i++) {
            if ( (int) chars[i] >= 48 && (int) chars[i] <= 57 ) {
                str += "*";
            } else {
                str += chars[i];
            }
        }
        System.out.println(str);

    }
}
