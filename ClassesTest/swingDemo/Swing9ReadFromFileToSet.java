package swingDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Program reads file .txt and adds each word to HashSet and TreeSet.
 * Then inputs count of words and time needed to calculate.
 */

public class Swing9ReadFromFileToSet {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/Users/arturfahreev/Downloads/hp4-goblet-of-fire.txt";
        File file = new File(filePath);

        Scanner sc = new Scanner(file);
        HashSet<String> set = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();


        long currentTime;
        long total = 0;
        long totalTreeSet = 0;
        String str;
        String strPattern = "[a-zA-Z'’]{2,}+"; //String starts with letter and ends with letter
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher;

        while (sc.hasNext()) {
            str = sc.next();
            str = str.trim();
            //str = str.toLowerCase();
            if (str.matches(strPattern)) {
                currentTime = System.currentTimeMillis();
                set.add(str);
                total += (System.currentTimeMillis() - currentTime);

                currentTime = System.currentTimeMillis();
                treeSet.add(str);
                totalTreeSet += (System.currentTimeMillis() - currentTime);

                treeMap.put(str, treeMap.getOrDefault(str, 0) + 1);

            } else {
                matcher = pattern.matcher(str);
                if (matcher.find()) {
                    str = str.substring(matcher.start(), matcher.end());
                    currentTime = System.currentTimeMillis();
                    set.add(str);
                    total += (System.currentTimeMillis() - currentTime);

                    currentTime = System.currentTimeMillis();
                    treeSet.add(str);
                    totalTreeSet += (System.currentTimeMillis() - currentTime);

                }
            }
        }

        System.out.println("Total HashSet time: " + total);
        System.out.println("Total TreeSet time: " + totalTreeSet);
        System.out.println("Count of set members HashSet: " + set.size());
        System.out.println("Count of set members TreeSet: " + treeSet.size());
        System.out.println();

        Iterator<String> iter = set.iterator();
        System.out.println("First members of HashSet: ");
        for (int i = 1; i < 100 ; i++) {
            if (iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
        System.out.println();

        Iterator<String> iterTree = treeSet.iterator();
        System.out.println("First members of TreeSet: ");
        for (int i = 1; i < 100 ; i++) {
            if (iterTree.hasNext()) {
                System.out.println(iterTree.next());
            }
        }
        System.out.println();

        List<Map.Entry<String, Integer>> listOfEntries = new ArrayList<>(treeMap.entrySet());
        listOfEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("Members of Map: ");
        listOfEntries.forEach(entry -> System.out.println(entry.getValue() + " - " + entry.getKey()));
    }
}
