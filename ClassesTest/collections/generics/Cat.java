package collections.generics;

public class Cat extends Animal {

    public Cat(String str) {
        super(str);
    }

    @Override
    public void eat() {
        System.out.println(Cat.class.getName() + " " + str + " is eating");
    }

    public void jump () {
        System.out.println("Jumping");
    }


}
