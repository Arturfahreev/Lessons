import java.util.Scanner;
//Выводит простые делители числа
public class Test21DecompositionOnPrimal {
    public static int lastPrime = -1;

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //task(2, n);
        int n = 0;
        for (int i = 1001; i < 1101; i += 11) {
            n = i;
            System.out.println("Number " + n);
            task(2, n);
        }
    }
    public static void task (int divider, int n) {
        if (n > 1 && divider <= n) {
            if (n % divider == 0) {

                System.out.println(divider + " ");
                n /= divider;
            } else {
                divider += 1;
            }
            task(divider, n);
        }
    }
}
