import java.util.Scanner;
/**Пользователь вводит сначала n (кол-во чисел), затем последовательно n чисел.
Вывести два наибольших числа (первым вывести максимальное, вторым - следующее по величине)
*/
public class Test30TwoMaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        twoMaxNumber(n, array);
    }
    public static void twoMaxNumber (int n, int[] array) {
        Scanner sc = new Scanner(System.in);

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            if ( array[i] > max1 ) {
                max2 = max1;
                max1 = array[i];
            }

            if ( array[i] > max2 & array[i] < max1) {
                max2 = array[i];
            }
        }
        System.out.println("max1: " + max1);
        System.out.println("max2: " + max2);
    }
}
