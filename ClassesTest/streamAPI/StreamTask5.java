package streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Дан класс Person с полями firstname, lastname, age.
 * Вывести полное имя самого старшего человека, у которого длина имени меньше 10 символов.
 */
public class StreamTask5 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ivan", "Ivanov", 10));
        personList.add(new Person("Petr", "Petrov", 20));
        personList.add(new Person("Vasya", "Vasilevich", 30));
        personList.add(new Person("Tom", "Tomovich", 40));
        personList.add(new Person("John", "Johnovich", 50));

        personList.stream()
                .filter(person -> person.getFullName().length() < 11)
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName() {
        return this.firstName + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
