import java.util.Scanner;
//Принимает строку и выдает строку без начального пробела
public class Test16DeleteFirstSpace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = deleteFirst(str);
        System.out.println(s);

    }
    public static String deleteFirst (String strOrigin) {
        char[] chars = strOrigin.toCharArray();
        boolean flag = true;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' || !flag) {
                result += chars[i];
                flag = false;
            }
        }
        return result;
    }
}
