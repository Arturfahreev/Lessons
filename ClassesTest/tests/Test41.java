package tests;
/**
 * Поле numbers должно быть типа ArrayList<Integer>.
 * Метод init() должен заполнять список numbers числами от 0 до 9.
 * Метод reverse() должен переставить значения списка numbers в обратном порядке.
 */

import java.util.ArrayList;

public class Test41 {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>(10);

    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
            numbers.add(i, i);
            System.out.println(numbers.get(i));
        }
    }

    public static void reverse() {
        int n = numbers.size() - 1;
        for (int i = 0; i < numbers.size() / 2; i++) {
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(n - i));
            numbers.set(n - i, temp);
        }
    }

    private static void print() {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
