
public class LinkedList implements List {
	private static class Node {
		Node next;
		Node previous;
		Object value;
	}
	
	public LinkedList() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}
	
	/**
	 * @invariant | sentinel != 0
	 * @representationObject
	 */
	private Node sentinel;
	
	@Override
	public int getSize() {
		int result = 0;
		for (Node n = sentinel; n != sentinel; n =  n.next) {
			result += 1;
		}
		return 0;
	}

	@Override
	public Object[] toArray() {
		ArrayList result = new ArrayList(0);
		for (Node n = sentinel; n != sentinel; n = n.next) {
			result.add(n.next.value);
		}
		return result.toArray();
	}

	@Override
	public Object get(int index) {
		int i = index;
		for (Node n = sentinel; n != sentinel; n = n.next) {
			if(index == 0) {
				return n.next.value;
			}
			else {
				i -= 1;
			}
		}
		assert(false);
		return null;
	}

	@Override
	public void set(int index, Object value) {
		int i = index;
		for (Node n = sentinel; n != sentinel; n = n.next) {
			if(index == 0) {
				n.next.value = value;
			}
			else {
				i -= 1;
			}
		}
		assert(false);
	}

	@Override
	public void add(Object value) {
		Node n = new Node();
		n.value = value;
		n.previous = sentinel.previous;
		sentinel.previous.next = n;
		sentinel.previous = n;
		n.next = sentinel;
	}

	@Override
	public void add(int index, Object value) {
		int i = index;
		for (Node n = sentinel; n != sentinel; n = n.next) {
			if(index == 0) {
				Node nn = new Node();
				nn.value = value;
				nn.next = n.next;
				n.next.previous = nn;
				n.next = nn;
				nn.previous = n;
			}
			else {
				i -= 1;
			}
		}
		assert(false);
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Object val) {
		// TODO Auto-generated method stub

	}

}
