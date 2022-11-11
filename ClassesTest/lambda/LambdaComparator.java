package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaComparator {
    public static void main(String[] args) {
        String[] arr = new String[]{"One", "Twoo", "Threeee", "Four", "Five"};
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
        System.out.println(list);

        };


}
