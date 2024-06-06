package Iterators;

import java.util.Iterator;

public class LinkedListIterator implements Iterator {

    public LinkedList.Node node;

    public LinkedListIterator(LinkedList linkedList) {
        node = linkedList.firstNode;
    }

    public boolean hasNext() { return node != null; }

    public Object next() {
        Object result = node.value;
        node = node.next;
        return result;
    }

}
