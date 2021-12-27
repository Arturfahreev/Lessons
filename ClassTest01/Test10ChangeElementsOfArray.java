import java.util.Scanner;
//Вводится строка, затем число, переставляющее циклически элементы строки вправо
public class Test10ChangeElementsOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int offset = sc.nextInt();

        char [] charArray = str.toCharArray();
        char [] newCharArray = new char[charArray.length];

        if (offset >= charArray.length) offset %= charArray.length;

        for (int i = 0; i < charArray.length; i++) {
            if (offset + i >= charArray.length) {
                newCharArray[offset + i - charArray.length] = charArray[i];
            } else {
                newCharArray[offset + i] = charArray[i];
            }
        }
        System.out.println(newCharArray);


    }
}
