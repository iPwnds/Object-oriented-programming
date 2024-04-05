
public class HashSet implements Set {
	/**
	 * @representationObject
	 * @representationObjects buckets
	 * @invariant | buckets != null
	 * @invariant | Arrays.stream(buckets).allMatch(i -> i != null)
	 */
	private Set[] buckets;
	
	public HashSet(int nbuckets) {
		buckets = new Set[nbuckets];
		for(int i = 0; i < nbuckets; ++i) {
			buckets[i] = new ArraySet();
		}
	}
	
	@Override
	public Object[] toArray() {
		ArrayList result = new ArrayList(getSize());
		for(Set bucket : buckets) {
			Object[] a = bucket.toArray();
			for(Object o : a) {
				result.add(o);
			}
		}
		return result.toArray();
	}

	@Override
	public int getSize() {
		return toArray().length;
	}

	@Override
	public void add(Object value) {
		int hash = value.hashCode();
		int shorthash = hash % buckets.length;
		buckets[shorthash].add(value);
	}

	@Override
	public void remove(Object value) {
		int hash = value.hashCode();
		int shorthash = hash % buckets.length;
		buckets[shorthash].remove(value);
	}

	@Override
	public boolean contains(Object value) {
		int hash = value.hashCode();
		int shorthash = hash % buckets.length;
		return buckets[shorthash].contains(value);
	}

}
