package tests;

public class Test45ConfusingConstructor {
    private Test45ConfusingConstructor(Object o) {
        System.out.println("Object");
    }
    private Test45ConfusingConstructor (double[] dArray) {
        System.out.println("double array");
    }

    public static void main(String[] args) {
        new Test45ConfusingConstructor(null);
    }
}
