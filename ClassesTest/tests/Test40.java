package tests;

import java.util.Arrays;

public class Test40 {

    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        char[] chars = string.toCharArray();
        int count = 0;
        for (char ch : chars) {
            if (Character.isDigit(ch)) count++;
        }
        return count;
    }

    public static int countLetters(String string) {
        char[] chars = string.toCharArray();
        int count = 0;
        for (char ch : chars) {
            if (Character.isLetter(ch)) count++;
        }
        return count;
    }

    public static int countSpaces(String string) {
        char[] chars = string.toCharArray();
        int count = 0;
        for (char ch : chars) {
            if (Character.isSpaceChar(ch)) count++;
        }
        return count;
    }
}
