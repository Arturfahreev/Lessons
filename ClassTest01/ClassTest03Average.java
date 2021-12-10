import java.util.Scanner;

public class ClassTest03Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] students = new int[n];
        int average = 0;
        int count = 0;
        for (int i = 0; i < n; i++){
            students[i] = sc.nextInt();
            average += students[i];
        }
        average = average / n;

        for (int i = 0; i < n; i++){
            if (students[i] > average) count++;
        }
        System.out.println("average: " + average);
        System.out.println("count: " + count);

        }
    }
