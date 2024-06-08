package Generics;

//class LinkedList implements Iterable {
//
//    static class Node {
//        Object element;
//        Node next;
//
//        Node(Object element, Node next) {
//            this.element = element;
//            this.next = next;
//        }
//    }
//
//    Node firstNode;
//
//    boolean contains(Object element) {
//        for (Node node = firstNode; node != null; node = node.next)
//            if (node.element == element)
//                return true;
//        return false;
//    }
//
//    public Iterator iterator() {
//        return new Iterator() {
//            Node node = firstNode;
//            public boolean hasNext() { return node != null; }
//            public Object next() {
//                Object result = node.element;
//                node = node.next;
//                return result;
//            }
//        };
//    }
//
//    void addFirst(Object element) {
//        firstNode = new Node(element, firstNode);
//    }
//}


class LinkedList<T> implements Iterable<T> {

    static class Node<T> {
        T element;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    Node<T> firstNode;

    boolean contains(T element) {
        for (Node<T> node = firstNode; node != null; node = node.next)
            if (node.element == element)
                return true;
        return false;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = firstNode;
            public boolean hasNext() { return node != null; }
            public T next() {
                T result = node.element;
                node = node.next;
                return result;
            }
        };
    }

    void addFirst(T element) {
        firstNode = new Node<T>(element, firstNode);
    }
    
    void addAll(LinkedList<? extends T> other) {
    	for (Iterator<? extends T> iterator = other.iterator(); iterator.hasNext(); )
    	    addFirst(iterator.next());
    }
    
    void copyInto(LinkedList<? super T> other) {
        for (Iterator<T> iterator = this.iterator(); iterator.hasNext(); )
    	    other.addFirst(iterator.next());
    }
    
    static <T> void copyInto(LinkedList<T> from, LinkedList<? super T> to) {
    	from.copyInto(to); // equivalently: to.addAll(from);
    }
    
    static <T> void copyInto2(LinkedList<? extends T> from, LinkedList<T> to) {
    	from.copyInto(to); // equivalently: to.addAll(from);
    }
    
    static <T> void copyInto3(LinkedList<? extends T> from, LinkedList<? super T> to) {
    	from.copyInto(to); // equivalently: to.addAll(from);
    }

}