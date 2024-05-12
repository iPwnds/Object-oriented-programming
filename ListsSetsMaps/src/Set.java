import java.util.Arrays;

public interface Set {
	public Object[] toArray();
	/**
	 * @post | result == toArray().length
	 */
	public int getSize();
	public void add(Object value);
	public void remove(Object value);
	/**
	 * @post | Arrays.stream(toArray()).anyMatch(v -> v.equals(value))
	 */
	public boolean contains(Object value);
}
