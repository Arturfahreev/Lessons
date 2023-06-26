package streamAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Дан список строк. Найти количество уникальных строк длиной больше 8 символов.
 */

public class StreamTask2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("String" + i);
            list.add("String" + i);
        }
    }
}
