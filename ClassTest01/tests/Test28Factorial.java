package tests;

public class Test28Factorial {
    public static void main(String[] args) {
        int numberFact = factorialFor(7);
        System.out.println("For: " + numberFact);
        int numberWhile = factorialWhile (8);
        System.out.println("While: " + numberWhile);
        int numberRecursia = factorialRecursion(9);
        System.out.println("Recursion: " + numberRecursia);
    }
    public static int factorialFor (int number) {
        int result = 1;
        for (int i = 1; i <= number ; i++) {
            result = result * i;
        }
        return result;
    }
    public static int factorialWhile (int number) {
        int result = 1;
        int i = 1;
        while ( i <= number ) {
            result = result * i;
            i++;
        }
        return result;

    }
    //F(3) = 3 * 2 * 1
    public static int factorialRecursion (int number) {
        if (number == 1) {
            return 1;
        }
        return number * factorialRecursion(number - 1);
    }

}
