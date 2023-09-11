package genericsRestrictions;

public class Test1 {
    public static void main(String[] args) {
        Pair<?>[] arr = new Pair[10];
        arr[0] = new Pair<String>("aa", "bb");
        arr[1] = new Pair<Integer>(1,2);
        String str = (String) arr[0].getFirst();
        System.out.println(str.contains("a"));
        Pair<Manager> managerPair = new Pair<>(new Manager("Bob", 12, 10), new Manager("Tom", 10, 10));
        Pair pair = managerPair;
        pair.setFirst(new String("abc"));
        Object obj = managerPair.getFirst();

    }
}
