package genericsLessonsEnglish;

public class Main {
    public static void main(String[] args) {
        PrintAnyObject<Integer> intName1 = new PrintAnyObject<>(87);
        intName1.printAnyObject();

        PrintAnyObject<String> stringName = new PrintAnyObject<>("Hi there!");
        stringName.printAnyObject();

        PrintAnyObject<Double> doubleName = new PrintAnyObject<>(65.1);
        doubleName.printAnyObject();

        PrintAnyObject<Cat> catName = new PrintAnyObject<Cat>(new Cat("Kitty"));
        catName.printAnyObject();


    }

}
