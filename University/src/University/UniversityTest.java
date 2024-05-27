package University;

interface Iterator<T> {
	boolean hasNext();
	T next();
}

class LinkedList<T> {
	class Node {
		T element;
		Node next;
		
		Node(T element, Node next) {
			this.element = element;
			this.next = next;
		}
	}
	
	Node first;
	
	void add(T element) {
		if (first == null)
			first = new Node(element, null);
		else {
			Node n = first;
			while (n.next != null)
				n = n.next;
			n.next = new Node(element, null);
		}
	}
	
	boolean contains(T element) {
		for (Node n = first; n != null; n = n.next)
			if (n.element == element)
				return true;
			return false;
	}
	
	Iterator<T> iterator() {
		return new Iterator<T>() {
			Node n = first;
			
			@Override
			public boolean hasNext() {
				return n != null;
			}
			
			@Override
			public T next() {
				Node n = this.n;
				this.n = n.next;
				return n.element;
			}
		};
	}
}

class Student {
	int nbCredits;
}

class StaffMember {
	int nbPubs;
}

interface StudentIterator {
	boolean hasNext();
	Student next();
}


class LinkedListOfStudents {
	class Node {
		Student student;
		Node next;
		
		Node(Student student, Node next) {
			this.student = student;
			this.next = next;
		}
	}
	
	Node first;
	
	void add(Student student) {
		if (first == null)
			first = new Node(student, null);
		else {
			Node n = first;
			while (n.next != null)
				n = n.next;
			n.next = new Node(student, null);
		}
	}
	
	boolean contains(Student student) {
		for (Node n = first; n != null; n = n.next)
			if (n.student == student)
				return true;
			return false;
	}
	
	StudentIterator iterator() {
		return new StudentIterator() {
			Node n = first;
			
			@Override
			public boolean hasNext() {
				return n != null;
			}
			
			@Override
			public Student next() {
				Node n = this.n;
				this.n = n.next;
				return n.student;
			}
		};
	}
}

class University {

	LinkedList<Student> students = new LinkedList<Student>();
	LinkedList<StaffMember> staffMembers = new LinkedList<StaffMember>();
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void addStaffMember(StaffMember staffMember) {
		staffMembers.add(staffMember);
	}
	
	public int getTotalStudentNbCredits() {
		int result = 0;
		for (Iterator<Student> i = students.iterator(); i.hasNext(); )
			result += i.next().nbCredits;
		return result;
	}
	
	public int getTotalNbPubs() {
		int result = 0;
		for (Iterator<StaffMember> i = staffMembers.iterator(); i.hasNext(); )
			result += i.next().nbPubs;
		return result;
	}
	
}
