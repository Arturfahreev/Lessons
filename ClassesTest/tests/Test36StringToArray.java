package tests;

import java.util.Arrays;

/**
 * Функция разбивает строку на равные части по n символов и сохраняющая отдельные части
 * в массив. Вывести этот массив.
 */
public class Test36StringToArray {
    public static void main(String[] args) {
        String str = "12345678908";
        int n = 3;
        System.out.println(Arrays.toString(split(str, n)));

    }
    public static String[] split (String str, int n) {
        int sizeArray = (int) Math.ceil(str.length() / (double) n);
        String[] result = new String[sizeArray];

        int count = 0;
        for (int i = 0; i < str.length(); i += n) {
            int endIndex = Math.min(str.length(), i + n);
            String substring = str.substring(i, endIndex);
            result[count] = substring;
            count++;
        }
        return result;

    }
}
