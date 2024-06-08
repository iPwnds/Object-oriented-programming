package Generics;

class LinkedListOfStudent implements IterableOfStudent {

    static class Node {
        Student element;
        Node next;

        Node(Student element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    Node firstNode;

    boolean contains(Student student) {
        for (Node node = firstNode; node != null; node = node.next)
            if (node.element == student)
                return true;
        return false;
    }

    public IteratorOfStudent iterator() {
        return new IteratorOfStudent() {
            Node node = firstNode;
            public boolean hasNext() { return node != null; }
            public Student next() {
                Student result = node.element;
                node = node.next;
                return result;
            }
        };
    }

    void addFirst(Student student) {
        firstNode = new Node(student, firstNode);
    }
}
