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
        for (int i = 0; i < 200; i++) {
            listInt.add(i);
        }
        listInt.stream()
                .filter(value -> value % 2 != 0)
                .filter(value -> value % 5 == 0)
                .map (String::valueOf)
                .filter(string -> string.length() > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
