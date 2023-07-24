package collections.methods;

import java.util.HashMap;
import java.util.Map;

public class MapCompute {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Книга-1");
        map.put(2, "Книга-2");
        map.put(3, "Книга-3");
        map.put(4, "Книга-4");
        map.put(5, "Книга-5");

        map.forEach((a,b) -> System.out.println("№" + a + " Name: " + b));
        map.compute(1, (a, b) -> b + " Автор" + a);
        System.out.println();
        map.forEach((a,b) -> System.out.println("№" + a + " Name: " + b));

    }
}
