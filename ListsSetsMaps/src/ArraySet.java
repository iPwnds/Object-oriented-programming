
public class ArraySet implements Set {
	/**
	 * @representationObject
	 * @invariant | a != null
	 */
	private ArrayList a;
	
	public ArraySet() {
		a = new ArrayList(10);
	}
	
	@Override
	public Object[] toArray() {
		return a.toArray();
	}

	@Override
	public int getSize() {
		return a.getSize();
	}

	@Override
	public void add(Object value) {
		a.add(value);
	}

	@Override
	public void remove(Object value) {
		// a.remove(value);
	}
		
	@Override
	public boolean contains(Object value) {
		// a.contains(value);
		return false;
	}

}
