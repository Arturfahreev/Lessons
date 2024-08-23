package collections.linkedList;

/**
 * Create your own LinkedList
 */

public class Task1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList);
    }

}

class LinkedList {
    Item first;
    Item last;

    LinkedList() {
    }

    void add(int value) {
        Item item = new Item(value);
        if (first == null) {
            first = item;
            last = item;
        } else {
            last.next = item;
            last = item;
        }
    }

    @Override
    public String toString() {
        String str = "{" + first + "}";
        str = str.replace("null", "");
        return str ;
    }
}

class Item {
    int value;
    Item next;

    Item(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " " + value + " " + next;
    }
}
