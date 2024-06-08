package Generics;

class Staff extends Member implements Comparable<Staff> {
    
    int nbPubs;
    
    public int compareTo(Staff other) { return nbPubs - other.nbPubs; }
    
}