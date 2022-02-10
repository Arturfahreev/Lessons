import java.util.Scanner;
//Проверяет является ли вводимая строка Палиндромом

public class Test02Palindrom {

    Scanner sc = new Scanner(System.in); //Вызываем сканер
    String str = sc.nextLine(); //считываем строку
    char[] arr = Palindrom(str); //помещаем стрроку в массив char

    static char[] Palindrom(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < (arr.length + 1) / 2; i++) {
            if (arr[i + 1] == arr[arr.length - i - 1]) arr[i] += ' ';
        }
        return arr;
    }

    public static boolean PalindromBoolean(char[] arr, int it) {
        if ((it - 1) == (arr.length / 2)) return arr[it] == arr[arr.length - (it) - 2];
        return (arr[arr.length - (it) - 1] == arr[it]) && PalindromBoolean(arr, --it);
    }
}