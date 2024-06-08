package Generics;

interface Comparable<T> {
    
    /**
     * Returns a negative number, zero, or a positive number if this object
     * compares as less than, equal to, or greater than {@code other}.
     */
    int compareTo(T other);
    
}
