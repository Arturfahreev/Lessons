package lambda;

public class LambdaTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Horse horse = new Horse();
        System.out.println(animal.jump(horse));

        animal.jump(() -> 1);


    }
}

class Horse implements Runnable {

    @Override
    public int run() {
        return 0;
    }
}

class Animal {

    public int jump(Runnable r) {
        return r.run();
    }
}

interface Runnable {
    int run();
}
