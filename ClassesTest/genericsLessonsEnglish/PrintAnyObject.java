package genericsLessonsEnglish;

public class PrintAnyObject<T> {
    T anyObject;

    public PrintAnyObject(T anyObject) {
        this.anyObject = anyObject;
    }

    public void printAnyObject() {
        System.out.println(anyObject);
    }
}
