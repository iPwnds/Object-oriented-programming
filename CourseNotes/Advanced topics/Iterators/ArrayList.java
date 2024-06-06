package Iterators;

import java.util.Iterator;

//public class ArrayList {
//
//    public Object[] elements;
//
//}


//public class ArrayList implements Iterable {
//
//    public Object[] elements;
//
//    public Iterator iterator() { return new ArrayListIterator(this); }
//
//}


//public class ArrayList implements Iterable {
//
//    private Object[] elements;
//
//    private static class IteratorImpl implements Iterator {
//
//        private ArrayList arrayList;
//        private int index;
//
//        private IteratorImpl(ArrayList arrayList) { this.arrayList = arrayList; }
//
//        public boolean hasNext() { return index < arrayList.elements.length; }
//
//        public Object next() { return arrayList.elements[index++]; }
//
//    }
//
//    public Iterator iterator() { return new IteratorImpl(this); }
//
//    // Constructors and mutators not shown
//
//}


//public class ArrayList implements Iterable {
//
//    private Object[] elements;
//
//    private class IteratorImpl implements Iterator {
//
//        private int index;
//
//        private IteratorImpl() {}
//
//        public boolean hasNext() { return index < ArrayList.this.elements.length; }
//
//        public Object next() { return ArrayList.this.elements[index++]; }
//
//    }
//
//    public Iterator iterator() { return new IteratorImpl(); }
//
//    // Constructors and mutators not shown
//
//}


//public class ArrayList implements Iterable {
//
//    private Object[] elements;
//
//    private class IteratorImpl implements Iterator {
//
//        private int index;
//
//        public boolean hasNext() { return index < elements.length; }
//
//        public Object next() { return elements[index++]; }
//
//    }
//
//    public Iterator iterator() { return new IteratorImpl(); }
//
//    // Constructors and mutators not shown
//
//}

//public class ArrayList implements Iterable {
//
//    private Object[] elements;
//
//    public Iterator iterator() {
//
//        class IteratorImpl implements Iterator {
//
//            private int index;
//
//            public boolean hasNext() { return index < elements.length; }
//
//            public Object next() { return elements[index++]; }
//
//        }
//
//        return new IteratorImpl();
//    }
//
//    // Constructors and mutators not shown
//
//}


//public class ArrayList implements Iterable {
//
//    private Object[] elements;
//
//    public Iterator iterator() {
//
//        return new Iterator() {
//
//            private int index;
//
//            public boolean hasNext() { return index < elements.length; }
//
//            public Object next() { return elements[index++]; }
//
//        };
//
//    }
//
//    // Constructors and mutators not shown
//
//}


public class ArrayList implements Iterable {

    public Object[] elements;

    public void forEach(Consumer consumer) {
        for (int i = 0; i < elements.length; i++)
            consumer.accept(elements[i]);
    }

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
