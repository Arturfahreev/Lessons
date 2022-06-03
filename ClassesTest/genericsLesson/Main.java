package genericsLesson;

public class Main {
    public static void main(String[] args) {
        PrintT<Integer> print1 = new PrintT<>(5, 76);
        print1.printT();

        PrintT<String> printString1 = new PrintT<>("Привет", "Мир");
        printString1.printT();

        PrintT<Double> printDouble1 = new PrintT<>(34.1, 54.3);
        printDouble1.printT();

        printO(printDouble1);
        printO(printString1);

    }

    public static void printO (PrintT o) {
        System.out.println(o);

    }



}
