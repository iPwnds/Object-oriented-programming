package Generics;

class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    
    @Override
    void addFirst(T element) {
        Node<T> sentinel = new Node<T>(null, firstNode);
        Node<T> node = sentinel;
        while (node.next != null && node.next.element.compareTo(element) < 0)
            node = node.next;
        node.next = new Node<T>(element, node.next);
        firstNode = sentinel.next;
    }
    
}
