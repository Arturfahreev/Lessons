import java.util.Scanner;
//Вводится массив чисел и выводится наибольшее число повторений одинаковых чисел подряд

public class Test13LongSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int currentResult = 0;
        int lastResult = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1] ) currentResult++;
            else currentResult = 0;
            if (currentResult > lastResult) lastResult = currentResult;
        }
        System.out.println(lastResult);

    }
}
