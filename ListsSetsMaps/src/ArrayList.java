import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @invariant | toArray().length == getSize()
 */
public class ArrayList implements List{
	/**
	 * @invariant | arr != null
	 * @representationObject
	 */
	private Object[] arr;
	/**
	 * @invatiant | size <= arr.length
	 */
	private int size;
	
	public ArrayList(int initialCap) {
		arr = new Object[initialCap];
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public Object[] toArray() {
		return Arrays.copyOf(arr, size);
	}
	
	/**
	 * @pre | 0 <= index
	 * @pre | index < getSize()
	 * @post | result == toArray() [index]
	 */
	public Object get(int index) {
		return arr[index];
	}
	
	public void set(int index, Object value) {
		arr[index] = value;
	}
	
	/**
	 * @post | IntStream.range(0, old(getSize())).allMatch(i -> toArray()[i] == old(toArray())[i])
	 * @post | toArray()[old(getSize())] == value
	 * @post | getSize() == old(getSize()) + 1
	 */
	public void add(Object value) {
		add(getSize(), value);
	}
	
	/**
	 * @pre | 0 <= index
	 * @pre | index <= getSize()
	 * @post | IntStream.range(0, index).allMatch(i -> toArray()[i] == old(toArray())[i])
	 * @post | toArray()[index] == value
	 * @post | IntStream.range(index,getSize() - 1).allMatch(i -> toArray()[i+1] == old(toArray())[i])
	 * @post | getSize() == old(getSize()) + 1
	 */
	public void add(int index, Object value) {
		if(arr.length > size) {
			System.arraycopy(arr, index, arr, index + 1, size - index);
			arr[index] = value;
		}
		else {
			int newsize = 2 * size;
			Object[] narr = new Object[newsize];
			System.arraycopy(arr, 0, narr, 0, index);
			narr[index] = value;
			System.arraycopy(arr, index, narr, index + 1, size - index);
			arr = narr;
		}
		size += 1;
	}

	public void remove(int index) {
		System.arraycopy(arr, index + 1, arr, index, size - index - 1);
		size -= 1;
	}

	public void remove(Object val) {
		
	}
}
