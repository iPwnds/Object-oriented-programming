package Iterators;

import java.util.Iterator;
import java.util.function.Predicate;
import java.lang.Iterable;

//public class ClientProgram {
//
//    public void printAll(ArrayList arrayList) {
//        for (int i = 0; i < arrayList.elements.length; i++)
//            System.out.println(arrayList.elements[i]);
//    }
//
//    public void printAll(LinkedList linkedList) {
//        for (LinkedList.Node node = linkedList.firstNode;
//             node != null;
//             node = node.next)
//            System.out.println(node.value);
//    }
//
//    public void printBoth(ArrayList arrayList, LinkedList linkedList) {
//        printAll(arrayList);
//        printAll(linkedList);
//    }
//
//}


//public class ClientProgram {
//
//    public void printAll(Iterator iterator) {
//        while (iterator.hasNext())
//            System.out.println(iterator.next());
//    }
//
//    public void printBoth(ArrayList arrayList, LinkedList linkedList) {
//        printAll(new ArrayListIterator(arrayList));
//        printAll(new LinkedListIterator(linkedList));
//    }
//
//}


//public class ClientProgram {
//
//    public void printAll(Iterable iterable) {
//        for (Iterator iterator = iterable.iterator(); iterator.hasNext(); )
//            System.out.println(iterator.next());
//    }
//
//    public void printBoth(Iterable collection1, Iterable collection2) {
//        printAll(collection1);
//        printAll(collection2);
//    }
//
//    
////    public void test(Iterable iterable) {
////    	for (Iterator iterator = iterable.iterator(); iterator.hasNext(); ) {
////    	    Object element = iterator.next();
////    	    System.out.println(element);
////    	}
////    }
//    
//    
//    public void test(Iterable iterable) {
//    	for (Object element : iterable) {
//            System.out.println(element);
//        }
//    }
//    
//}


//public class ClientProgram {
//
//    public void printAll(Iterable iterable) {
//        iterable.forEach(new Consumer() {
//
//            public void accept(Object value) {
//                System.out.println(value);
//            }
//
//        });
//    }
//
//    public void printBoth(Iterable collection1, Iterable collection2) {
//        printAll(collection1);
//        printAll(collection2);
//    }
//
//}


//public class ClientProgram {
//
//    public void printAll(Iterable iterable) {
//        iterable.forEach((Object value) -> { System.out.println(value); });
//        iterable.forEach(value -> System.out.println(value));
//    }
//
//    public void printBoth(Iterable collection1, Iterable collection2) {
//        printAll(collection1);
//        printAll(collection2);
//    }
//
//}


public class ClientProgram {

    public void printAll(Predicate condition, Iterable iterable) {
        iterable.forEach(value -> {
            if (condition.test(value))
                System.out.println(value);
        });
    }

    public void printBoth(Predicate condition,
            Iterable collection1, Iterable collection2) {
        printAll(condition, collection1);
        printAll(condition, collection2);
    }

}

