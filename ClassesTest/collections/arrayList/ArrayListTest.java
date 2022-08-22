package collections.arrayList;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        listString.add("frog");
        listString.add("dog");
        listString.add("do");
        listString.add("a");
        listString.add("z");
        listString.add("zzak");
        listString.add("mmga");
        listString.add("ab");
        listString.add("dogkjn");
        listString.add("horse");
        listString.add("horseui");
        listString.add("horseukmmini");
        listString.add("frogkjm");
        Collections.sort(listString);
        System.out.println(listString);
        Collections.sort(listString, new StringComparator());
        System.out.println(listString);

        List<Integer> listInt = new ArrayList<>();
        listInt.add(5);
        listInt.add(18);
        listInt.add(52);
        listInt.add(98);
        listInt.add(17);
        listInt.add(33);
        listInt.add(100);
        listInt.add(54);
        Collections.sort(listInt);
        System.out.println(listInt);
        Collections.sort(listInt, (o1, o2) -> {if (o1 < o2) return 1; else if (o1 > o2) return -1; else return 0;});
        System.out.println(listInt);

    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
                else return 0;
    }
}

