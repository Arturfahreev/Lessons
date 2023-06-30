package streamAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов.
 */

public class StreamTask3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Strin" + i, i);
        }
        map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .map(Map.Entry::getValue)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

}
