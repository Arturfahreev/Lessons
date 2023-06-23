package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Дан список чисел. Отсортировать числа только нечетные кратные 5, чья длина цифр больше 2.
 */

public class streamExample1 {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listInt.add(i);
        }
        List<Integer> collect = listInt.stream()
                .filter(value -> value % 2 != 0)
                .filter(value -> value % 5 == 0)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
