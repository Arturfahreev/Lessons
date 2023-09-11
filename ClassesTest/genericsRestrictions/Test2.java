package genericsRestrictions;

public class Test2 {
    public static void main(String[] args) {
        Manager manager1 = new Manager("Bob", 10, 100);
        Manager manager2 = new Manager("Tom", 20, 200);
        Manager manager3 = new Manager("John", 30, 300);
        Manager manager4 = new Manager("Amanda", 40, 400);

        Manager[] arrManager = {manager1, manager2, manager3, manager4};

        Pair<Employee> result = new Pair<>(manager1, manager2);

        printBuddies(result);

        minMax(arrManager, result);

        System.out.println(result.getFirst().getName() + " " +
                result.getSecond().getName());

        maxMin(arrManager, result);

        System.out.println(result.getFirst().getName() + " " +
                result.getSecond().getName());

    }
    public static void printBuddies (Pair<? extends Employee> pair) {
        Employee first = pair.getFirst();
        Employee second = pair.getSecond();
        System.out.println(first.getName() + " " + second.getName());
    }

    public static void minMax (Manager[] arr, Pair<? super Manager> result) {
        if (arr.length == 0) return;
        Manager min = arr[0];
        Manager max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getBonus() < min.getBonus()) min = arr[i];
            if (arr[i].getBonus() > max.getBonus()) max = arr[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }
    public static void maxMin(Manager[] arr, Pair<? super Manager> result) {
        minMax(arr, result);
        minMaxSwitcher(result);
    }
    public static void minMaxSwitcher (Pair<?> pair) {
        ArrAlg.switchHelper(pair);
    }
class ArrAlg {
        public static <T> void switchHelper (Pair<T> pair) {
            T second = pair.getSecond();
            pair.setSecond(pair.getFirst());
            pair.setFirst(second);
        }
}
}
