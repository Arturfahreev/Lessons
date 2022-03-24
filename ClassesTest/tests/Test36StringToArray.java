package tests;

import java.util.Arrays;

/**
 * Функция разбивает строку на равные части по n символов и сохраняющая отдельные части
 * в массив. Вывести этот массив.
 */
public class Test36StringToArray {
    public static void main(String[] args) {
        String str = "0123456789";
        int n = 3;
        String[] result = split(str, n);
        System.out.println(Arrays.toString(result));

    }
    public static String[] split (String str, int n) {
        int sizeArray = (int) Math.ceil(str.length() / (double) n);//определяем размер конечного массива
        String[] result = new String[sizeArray];

        int count = 0; // счетчик для конечного массива
        for (int i = 0; i < str.length(); i += n) {
            int endIndex = Math.min(str.length(), i + n);//чтобы не выйти за рамки массива определяем конечный индекс
            String substring = str.substring(i, endIndex);
            result[count] = substring;
            count++;
        }
        // i = 0, substring[0 1 2]
        // i = 3, substring[3 4 5]
        // i = 6, substring[6 7 8]
        // i = 9, substring[9]
        return result;

    }
}
