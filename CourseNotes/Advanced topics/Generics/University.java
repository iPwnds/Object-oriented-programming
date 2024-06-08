package Generics;

//class University {
//    
//    private LinkedListOfStudent students = new LinkedListOfStudent();
//    private LinkedListOfStaff staffMembers = new LinkedListOfStaff();
//
//    void addStudent(Student student) {
//        students.addFirst(student);
//    }
//
//    boolean hasStudent(Student student) {
//        return students.contains(student);
//    }
//
//    /** Returns the number of students that have obtained at least 120 credits. */
//    int getNbFinishers() {
//        int result = 0;
//        for (IteratorOfStudent iterator = students.iterator();
//             iterator.hasNext(); ) {
//            Student student = iterator.next();
//            if (student.nbCredits >= 120)
//                result++;
//        }
//        return result;
//    }
//
//    void addStaff(Staff staff) {
//        staffMembers.addFirst(staff);
//    }
//
//    boolean hasStaff(Staff staff) {
//        return staffMembers.contains(staff);
//    }
//
//    /**
//     * Returns the average number of scientific publications authored by this
//     * university's staff members.
//     */
//    int getAvgNbPubs() {
//        int nbStaff = 0;
//        int totalNbPubs = 0;
//        for (IteratorOfStaff iterator = staffMembers.iterator();
//             iterator.hasNext(); ) {
//            Staff staff = iterator.next();
//            nbStaff++;
//            totalNbPubs += staff.nbPubs;
//        }
//        return totalNbPubs / nbStaff;
//    }
//
//}


//class University {
//    
//    private LinkedList students = new LinkedList();
//    private LinkedList staffMembers = new LinkedList();
//
//    void addStudent(Student student) {
//        students.addFirst(student);
//    }
//
//    boolean hasStudent(Student student) {
//        return students.contains(student);
//    }
//
//    /** Returns the number of students that have obtained at least 120 credits. */
//    int getNbFinishers() {
//        int result = 0;
//        for (Iterator iterator = students.iterator(); iterator.hasNext(); ) {
//            Student student = (Student)iterator.next(); // Typecast!
//            if (student.nbCredits >= 120)
//                result++;
//        }
//        return result;
//    }
//
//    void addStaff(Staff staff) {
//        staffMembers.addFirst(staff);
//    }
//
//    boolean hasStaff(Staff staff) {
//        return staffMembers.contains(staff);
//    }
//
//    /**
//     * Returns the average number of scientific publications authored by this
//     * university's staff members.
//     */
//    int getAvgNbPubs() {
//        int nbStaff = 0;
//        int totalNbPubs = 0;
//        for (Iterator iterator = staffMembers.iterator(); iterator.hasNext(); ) {
//            Staff staff = (Staff)iterator.next(); // Typecast!
//            nbStaff++;
//            totalNbPubs += staff.nbPubs;
//        }
//        return totalNbPubs / nbStaff;
//    }
//
//}


class University {
    
	
//    private LinkedList<Student> students = new LinkedList<Student>();
//    private LinkedList<Staff> staffMembers = new LinkedList<Staff>();

    
    private LinkedList<Student> students = new SortedLinkedList<>();
    private LinkedList<Staff> staffMembers = new SortedLinkedList<>();

    void addStudent(Student student) {
        students.addFirst(student);
    }

    boolean hasStudent(Student student) {
        return students.contains(student);
    }

    /** Returns the number of students that have obtained at least 120 credits. */
    int getNbFinishers() {
        int result = 0;
        for (Iterator<Student> iterator = students.iterator();
             iterator.hasNext(); ) {
            Student student = iterator.next();
            if (student.nbCredits >= 120)
                result++;
        }
        return result;
    }

    void addStaff(Staff staff) {
        staffMembers.addFirst(staff);
    }

    boolean hasStaff(Staff staff) {
        return staffMembers.contains(staff);
    }

    /**
     * Returns the average number of scientific publications authored by this
     * university's staff members.
     */
    int getAvgNbPubs() {
        int nbStaff = 0;
        int totalNbPubs = 0;
        for (Iterator<Staff> iterator = staffMembers.iterator();
             iterator.hasNext(); ) {
            Staff staff = iterator.next();
            nbStaff++;
            totalNbPubs += staff.nbPubs;
        }
        return totalNbPubs / nbStaff;
    }
    
    
//    LinkedList<Member> getMembers() {
//    	LinkedList<Member> members = new LinkedList<>();
//    	members.addAll(students);
//    	staffMembers.copyInto(members);
//    	return members;
//    }
    
    
//    LinkedList<Member> getMembers() {
//        LinkedList<Member> members = new LinkedList<>();
//        LinkedList.<Student>copyInto(students, members);
//        LinkedList.<Staff>copyInto(staffMembers, members);
//        return members;
//    }
    
    
//    LinkedList<Member> getMembers() {
//        LinkedList<Member> members = new LinkedList<>();
//        LinkedList.copyInto(students, members);
//        LinkedList.copyInto(staffMembers, members);
//        return members;
//    }
    
    
    static <T> LinkedList<T> copy(LinkedList<T> list) {
        LinkedList<T> result = new LinkedList<>();
        result.addAll(list);
        return result;
    }

}
