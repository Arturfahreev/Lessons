package collections.generics;

public class Animal implements Eatable {
    String str;

    public Animal(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

    public void eat () {
        System.out.println(str + " is eating");
    }
}
