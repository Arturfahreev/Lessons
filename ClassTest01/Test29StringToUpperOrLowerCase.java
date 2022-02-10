import java.util.Scanner;

public class Test29StringToUpperOrLowerCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = sc.next();

        System.out.println("Введите код ( l / u ): ");
        String key = sc.next();

        char[] chars = str.toCharArray();
        String result = "";

        for (int i = 0; i < chars.length; i++) {
            if (key.equals("u")) {
                    result += ( (int) chars[i] >= 97 ) ? ((char) (chars[i] - 32)) : chars[i];
                } else if (key.equals("l")) {
                result += ( (int) chars[i] >= 65 && (int) chars[i] <= 90 ) ? (char) (chars[i] + 32) : chars[i];
            }
        }
        System.out.println(result);

    }
}
