package javarush;

/**
 * При добавлении нового элемента предыдущие элементы должны получать на него ссылку.
 * При добавлении нового элемента он должен получать ссылку на предыдущий.
 */

public class Task03LinkedList {
    public static void main(String[] args) {
        StringsLinkedList stringsLinkedList = new StringsLinkedList();
        stringsLinkedList.add("1");
        stringsLinkedList.add("2");
        stringsLinkedList.add("3");
        stringsLinkedList.add("4");
        stringsLinkedList.add("5");
        stringsLinkedList.add("6");
        stringsLinkedList.add("7");
        stringsLinkedList.add("8");
        stringsLinkedList.add("9");
        stringsLinkedList.printAll();
    }
}

    class StringsLinkedList {
        private Node first = new Node();
        private Node last = new Node();

        public StringsLinkedList() {
            first.next = last;
            last.prev = first;
        }


        public void printAll() {
            Node currentElement = first.next;
            while ((currentElement) != null) {
                System.out.println(currentElement.value);
                currentElement = currentElement.next;
            }
        }

        public void add(String value) {
            Node nd = new Node();
            nd.value = value;

            Node x = this.last.prev; //создаем копию предыдущей ноды

            x.next = nd;
            nd.prev = x;

            nd.next = this.last;
            this.last.prev = nd;
        }

        public static class Node {
            private Node prev;
            private String value;
            private Node next;
        }
    }

