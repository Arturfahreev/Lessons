package genericsLesson;

public class PrintT<T> {
    T object1;
    T object2;

    public PrintT (T object1, T object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public void printT() {
        System.out.println(object2 + " " + object1);
    }

    @Override
    public String toString() {
        return null;
    }

}
