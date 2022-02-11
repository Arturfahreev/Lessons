package tests;

import java.util.Scanner;
//Пользователь вводить строку и два числа n1 и n2, затем удаляются из строки эти буквы и выводится новая строка
public class Test09DeleteChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int intStart = sc.nextInt();
        int intFinish = sc.nextInt();
        String strResult = "";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i < intStart || i > intFinish) {
                strResult += charArray[i];
            }
        }
        System.out.println(strResult);


    }
}
