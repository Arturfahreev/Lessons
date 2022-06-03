package collections.generics;

public class PrintT<T extends Animal> {
    T example;

    public PrintT(T example) {
        this.example = example;
    }

    public void printT() {
        System.out.println(example);
    }
}
