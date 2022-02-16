package tests;

import java.util.Scanner;

/**
 * Проверяет являтся ли число простым.
 * Проверяется циклом и если число не является делителем, то вносится в массив.
 * Затем следующее число сначала проверяется, не является ли числа в массиве делителем этого числа.
 * Если являются, то переходит к следующему числу.
 *
 */

public class Test35IsPrimeLongToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long startTime = System.currentTimeMillis();
        long result = isPrimeNumber(n);

        if (result == 0) System.out.println("Is prime");
        else System.out.println("Not prime, divider: " + result);

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent + " миллисекунд");

    }

    public static long[] addToArray (long n, long[] array) { //Добавляет новые числа в массив
        if (array.length == 1) {
            array[0] = n;
            return array;
        } else {
            long[] newArray = new long[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[newArray.length - 1] = n;
            return newArray;
        }

    }
    public static long isPrimeNumber (long n) {
        long result = 0;
        long[] arrayInt = new long[1];

        long i = 2;
        do {
            if ((i == 2) && (n % i == 0)) {
                result = i;
                return result;
            } else if ((i == 2) && (n % i != 0)) {
                arrayInt = addToArray(i, arrayInt);
                i++;
            }

            for (int j = 0; j < arrayInt.length; j++) { //Проверяет не делится ли i на числа в массиве
                if (i % arrayInt[j] == 0) {
                    i++;
                    break;
                }
            }

            if (n % i != 0) {
                arrayInt = addToArray(i, arrayInt);
                i++;
            } else if (n % i == 0) {
                result = i;
                return result;
            }
        } while (i < n / 2);

        return result;
    }
}
