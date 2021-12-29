import java.util.Scanner;
//Вводится массив строк, затем строки сортируются по возрастанию длины

public class Test15SortStringByLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.nextLine();
        }

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length - 1 - i; j++) {
                if (strings[j].length() > strings[j + 1].length()) {
                    String buffer = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = buffer;
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }


    }
}
