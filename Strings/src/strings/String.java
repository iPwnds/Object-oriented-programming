package strings;

/**
 * Elke instantie van deze klasse stelt een stuk tekst (=een reeks tekens) voor.
 * 
 * @immutable
 */
public class String {

	/**
	 * @inspects | this
	 * 
	 * @post | result != null
	 */
	public char[] toArray() { throw new RuntimeException("Not yet implemented");}
	
	/**
	 * @inspect | this
	 * 
	 * @ post | result == toArray().length
	 */
	public int length() { throw new RuntimeException("Not yet implemented");}
	
	/**
	 * @inspect | this
	 * 
	 * @pre | 0 <= index && index < length()
	 * @post | result == toArray()[index]
	 */
	public char charAt(int index) { throw new RuntimeException("Not yet implemented");}
	
	/**
	 * @pre contents != null
	 * 
	 * @post | Arrays.equals(toArray(), contents)
	 * 
	 * Alternative postcondities:
	 * @post | this.length() == contents.length
	 * @post | IntStream.range(0, contents.length).allMatch(i -> this.charAt(i) -- contents[i])
	 */
	public String(char[] contents) { throw new RuntimeException("Not yet implemented");}
}
