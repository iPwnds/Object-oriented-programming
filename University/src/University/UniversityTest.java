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

class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
	public void add(T element) {
		if (first == null)
			first = new Node(element, null);
		else if (element.compareTo(first.element) <= 0)
			first = new Node(element, first);
		else {
			Node n = first;
			while (n.next != null && element.compareTo(n.next.element) <= 0)
				n = n.next;
			n.next = new Node(element, n.next);
		}
	}
}

class Student implements Comparable<Student> {
	int nbCredits;
	
	@Override
	public int compareTo(Student o) {
		return nbCredits - o.nbCredits;
	}
}

class StaffMember {
	int nbPubs;
}

class University {

	LinkedList<Student> students = new SortedLinkedList<Student>();
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
