package Generics;

class LinkedListOfStaff implements IterableOfStaff {

    static class Node {
    	Staff element;
        Node next;

        Node(Staff element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    Node firstNode;

    boolean contains(Staff staff) {
        for (Node node = firstNode; node != null; node = node.next)
            if (node.element == staff)
                return true;
        return false;
    }

    public IteratorOfStaff iterator() {
        return new IteratorOfStaff() {
            Node node = firstNode;
            public boolean hasNext() { return node != null; }
            public Staff next() {
            	Staff result = node.element;
                node = node.next;
                return result;
            }
        };
    }

    void addFirst(Staff staff) {
        firstNode = new Node(staff, firstNode);
    }
}