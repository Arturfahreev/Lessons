package collections.tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Написать метод isUnique, который принимает Map&lt;String, String&gt;
 * и возвращает true,
 * если каждому ключу соответствуют свое уникальное значение.
 * Например, в данном случае вернётся true:
 * {Marty=Stepp, Stuart=Reges, Jessica=Miller, Amanda=Camp,
 * Hal=Perkins}
 * А в данном false:
 * {Kendrick=Perkins, Stuart=Reges, Jessica=Miller, Bruce=Reges,
 * Hal=Perkins} 
 */

public class Task1 {
    public static final int COUNT = 10;

    public static void main(String[] args) {

        Map<String, String> uniqueMap = createUniqueValue();
        Map<String, String> notUniqueMap = createNotUniqueValue();

        System.out.println("UniqueMap = " + isUnique(uniqueMap) );
        System.out.println("NotUniqueMap = " + isUnique(notUniqueMap));

        System.out.println(uniqueMap.toString());
        System.out.println(notUniqueMap.toString());

    }

    private static boolean isUnique (Map<String, String> map) {
        Set<String> set = new HashSet<>();
        boolean flag = true;
        for (String value : map.values()) {
            flag = set.add(value);
            if (!flag) {
                return flag;
            }
        }
        return flag;
    }

    private static Map<String, String> createUniqueValue() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), "String" + i);
        }
        return map;
    }

    private static Map<String, String> createNotUniqueValue() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < COUNT; i++) {
            if (i % 2 == 0) {
                map.put(String.valueOf(i), "String");

            } else {
                map.put(String.valueOf(i), "String" + i);
            }
        }
        return map;
    }
}
