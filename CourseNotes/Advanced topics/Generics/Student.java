package Generics;

class Student extends Member implements Comparable<Student> {
    
    int nbCredits;
    
    public int compareTo(Student other) { return nbCredits - other.nbCredits; }
    
}