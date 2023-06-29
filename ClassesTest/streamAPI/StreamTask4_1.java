package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Дан список целых чисел. Вывести строку,
 * представляющую собой конкатенацию строковых представлений этих чисел.
 * Например, список: {1, 2, 3, 4, 5}.
 * Вывод строки: "12345".
 */
public class StreamTask4_1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        String collect = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(collect);

    }
}
