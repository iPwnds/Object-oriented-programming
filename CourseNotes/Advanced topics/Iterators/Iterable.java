package Iterators;

import java.util.Iterator;

//public interface Iterable {
//    /** Returns a new iterator that points to the start of the data structure. */
//    Iterator iterator();
//}


//public interface Iterable {
//    void forEach(Consumer consumer);
//}


public interface Iterable {
    Iterator iterator();
    default void forEach(Consumer consumer) {
        for (Iterator i = iterator(); i.hasNext(); )
            consumer.accept(i.next());
    }
}
