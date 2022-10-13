package javarush;

/**
 * Реализовать метод get(int), который вернет строку под индексом, переданным в метод.
 * Если строки с таким индексом нет, нужно вернуть null.
 */

public class Task04LinkedListGet {
    public static void main(String[] args) {
        StringsLinkedList1 stringsLinkedList1 = new StringsLinkedList1();
        stringsLinkedList1.add("1");
        stringsLinkedList1.add("2");
        stringsLinkedList1.add("3");
        stringsLinkedList1.add("4");
        stringsLinkedList1.add("5");
        stringsLinkedList1.add("6");
        stringsLinkedList1.add("7");
        stringsLinkedList1.add("8");
        stringsLinkedList1.add("9");
        System.out.println(stringsLinkedList1.get(9)); // 5
    }
}

class StringsLinkedList1 {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        String result = null;
        Node x = first.next;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result = x.value;
                return result;
            }
            if (x.next != null) x = x.next;
            else break;

        }

        return result;
    }


    public static class Node {
        private Node prev;
        private String value = null;
        private Node next;

        public String getValue () {
            return value;
        }

        public Node getNext() {
            return next;
        }
        public Node getPrev() {
            return prev;
        }

    }
}

