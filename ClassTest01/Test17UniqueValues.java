import java.util.Scanner;
//Вводится массив чисел и определяется есть ли одинаковые элементы в нем

public class Test17UniqueValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        boolean result = uniqueValues(numbers);
        System.out.println(result);
    }
    public static boolean uniqueValues (int[] numbersArray) {
        boolean finalResult = false;
        for (int i = 0; i < numbersArray.length; i++) {
            for (int j = i + 1; j < numbersArray.length; j++) {
                if (numbersArray[i] == numbersArray[j]) {
                    finalResult = true;
                    break;
                }
            }
        }
        return finalResult;
    }
}
