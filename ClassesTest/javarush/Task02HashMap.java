package javarush;
/**
 * Метод printStudents должен выводить всех студентов (имя и фамилия) из коллекции grades с новой строки.
 * Метод getAverageMark должен возвращать средний балл всех студентов из коллекции grades.
 */

import java.util.HashMap;
import java.util.Set;

public class Task02HashMap {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println("Список студентов группы: ");
        printStudents();
        System.out.print("Средний балл группы: " + getAverageMark());
    }

    public static void addStudents() {
        grades.put("Давыдов Олег", 4.3d);
        grades.put("Шульга Николай", 4.1d);
        grades.put("Колос Василий", 4.9d);
        grades.put("Шевченко Тарас", 3.7d);
        grades.put("Марчук Любослав", 3.2d);
    }

    public static void printStudents() {
        Set<String> keys = grades.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }

    public static Double getAverageMark() {
        Set<String> keys = grades.keySet();
        double result = 0;
        for (String key : keys) {
            result = result + grades.get(key);
        }
        return result / grades.size();
    }
}
