import java.util.Scanner;

public class Test05LocalMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            if ((i >= 2) && (numbers[i - 1] > numbers[i - 2] && numbers[i - 1] > numbers[i])) {
                count++;
            }
        }
        System.out.println(count);
    }
}

