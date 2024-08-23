package collections.tasks;

import java.util.*;

/**
 * Сложить два многочлена заданной степени, если коэффициенты
 * многочлена хранятся в объекте HashMap в виде:
 * Ключ: номер степени
 * Значение: значение множителя
 * Вывести результирующий многочлен в виде строки: ax^6 + bx^4 +
 * cx^3 + dx + 8
 */

public class Task2 {
    public static final int COUNT = 15;
    public static final Random RANDOM = new Random();


    public static void main(String[] args) {
        Map<Integer, Integer> polynomial1 = createPolynomial();
        Map<Integer, Integer> polynomial2 = createPolynomial();
        System.out.println(polynomial1);
        System.out.println(polynomial2);
        Map<Integer, Integer> sumMap = sumPolynomial(polynomial1, polynomial2);
        System.out.println(convertToString(sumMap));
    }

    public static String convertToString(Map<Integer, Integer> map) {
        TreeMap<Integer, Integer> resultTreeMap = new TreeMap<>(Comparator.reverseOrder());
        resultTreeMap.putAll(map);
        StringBuilder stringBuilder = new StringBuilder();
        boolean start = true;

        for (Map.Entry<Integer, Integer> entry : resultTreeMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 0) continue;

            if (!start) {
                if (value > 0) {
                    if (key == 0) {
                        stringBuilder.append(" + " + value + "x");
                    } else {
                        stringBuilder.append(" + " + value + "x^" + key);
                    }
                } else {
                    if (key == 0) {
                        stringBuilder.append(" - " + Math.abs(value) + "x");
                    } else {
                        stringBuilder.append(" - " + Math.abs(value) + "x^" + key);
                    }
                }
            }

            if (start) {
                if (value > 0) {
                    stringBuilder.append(value + "x^" + key);
                } else {
                    stringBuilder.append(" - " + Math.abs(value) + "x^" + key);
                }
                start = false;
            }


        }
        return stringBuilder.toString();
    }

    private static Map<Integer, Integer> createPolynomial() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < COUNT; i++) {
            map.put(i, RANDOM.nextInt(COUNT) - RANDOM.nextInt(COUNT));
        }
        return map;
    }
    private static Map<Integer, Integer> sumPolynomialWthMerge(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        HashMap<Integer, Integer> resultMap = new HashMap<>(map1);
        for (var entry2 : map2.entrySet()) {
            resultMap.merge(entry2.getKey(), entry2.getValue(), Integer::sum);
        }
        return resultMap;
    }
        private static Map<Integer, Integer> sumPolynomial(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        HashMap<Integer, Integer> resultMap = new HashMap<>(map1);
        for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
            Integer key2 = entry2.getKey();
            Integer value2 = entry2.getValue();
            Integer value1 = resultMap.getOrDefault(key2, 0);
            resultMap.put(key2, value1 + value2);
        }
        return resultMap;

    }




}
