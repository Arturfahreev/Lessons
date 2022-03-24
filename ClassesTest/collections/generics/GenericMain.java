package collections.generics;

import java.util.ArrayList;

public class GenericMain {
    public static void main(String[] args) {

        Animal animal1 = new Animal("Animal1");
        Cat cat1 = new Cat("Cat1");
        Cat cat2 = new Cat("Cat2");
        Dog dog1 = new Dog("Dog1");
        Dog dog2 = new Dog("Dog2");

        System.out.println(animal1);
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(dog1);
        System.out.println(dog2);


        PrintT<Cat> cat3 = new PrintT<>(new Cat("Cat3"));
        cat3.printT();

        ArrayList<Animal> listT = new ArrayList<>();
        listT.add(dog1);

        Animal newCat = listT.get(0);

    }
}
