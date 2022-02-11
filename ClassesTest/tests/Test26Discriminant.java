package tests;//Решает квадратичное уравнение
import java.util.Random;

public class Test26Discriminant {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            int a = random.nextInt(10) - 4;
            int b = random.nextInt(100) - 40;
            int c = random.nextInt(10) - 4;

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);

            double discriminant = discriminant(a, b, c);

            if (discriminant > 0 & a != 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("x1: " + x1);
                System.out.println("x2: " + x2);
            } else if (discriminant == 0 & a != 0) {
                double x = (-b) / (2 * a);
                System.out.println("x: " + x);
            } else {
                System.out.println("Discriminant is negative");
            }
            System.out.println();
        }
    }

    public static double discriminant (int a, int b, int c) {
        return b * b - 4 * a * c;
    }
}
