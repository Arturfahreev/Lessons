package tests;

import java.util.Arrays;

public class Test46Arrays {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] ints = Arrays.copyOf(array, 7);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
            System.out.println();

        }
    }
}
