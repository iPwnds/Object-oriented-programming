package University;

import java.util.Arrays;

import org.junit.Test;

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
	
	T[] toArray(T[] prototype) {
		T[] result = prototype;
		result = Arrays.copyOf(prototype, 100);
		int i = 0;
		for (Node n = first; n != null; n= n.next)
			result[i++] = n.element;
		return result;
	}
	
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
	
	void addAll(LinkedList<? extends T> other) { // upper-bound wildcard
		for (Iterator<? extends T> i = other.iterator(); i.hasNext(); )
			add(i.next());
	}
	
	void copyInto(LinkedList<? super T> other) { // lower-bounded wildcard
		for (Iterator<T> i =this.iterator(); i.hasNext(); )
			other.add(i.next());
	}
	
	static <T> void copyInto(LinkedList<T> from, LinkedList<? super T> to) {
		from.copyInto(to);
	}	
}

class SortedLinkedList<T extends Comparable<? super T>> extends LinkedList<T> {
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

abstract class Member implements Comparable<Member> {
	int seniority;
	
	@Override
	public int compareTo(Member o) {
		return seniority - o.seniority;
	}
}

class Student extends Member {
	int nbCredits;
}

class StaffMember extends Member {
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
	
	public LinkedList<Member> getAllMembers() {
		LinkedList<Member> result = new LinkedList<Member>();
		result.addAll(students);
		LinkedList.copyInto(staffMembers, result);
		return result;
	}
}

class UniversutyTest {
	
	@Test
	void test() {
		LinkedList<StaffMember> myList = new LinkedList<StaffMember>();
		myList.add(new StaffMember());
		Object o = myList;
		LinkedList<Student> myStudents = (LinkedList<Student>)o;
		System.out.println(myStudents.iterator().next().nbCredits);
	}
}
