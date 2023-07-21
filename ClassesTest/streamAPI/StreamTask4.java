package streamAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Дан список целых чисел. Вывести строку, представляющую собой
 * конктенацию строковых представлений этих чисел.
 * Пример, список {1, 2, 3}.
 * Результирующая строка: "123".
 */
public class StreamTask4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.stream();
    }
}
