import java.util.Scanner;

public class Test04ConvertIntToStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        String str = "";
        for (int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
            str += numbers[i];
        }
        long n1 = Long.parseLong(str);
        System.out.println(n1);
    }
}
