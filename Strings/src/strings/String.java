package strings;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van deze klasse stelt een stuk tekst (=een reeks tekens) voor.
 * 
 * @immutable
 */
public class String {
	
	/**
	 * @invar | contents != null
	 */
	private char[] contents;
	
	/**
	 * @inspects | this
	 * 
	 * @post | result != null
	 */
	public char[] toArray() { 
		//return contents; //FOUT! REPRESENTATION EXPOSURE! LEAKS REPRESENTATION OBJECT
		return contents.clone();
	}
	
	/**
	 * @inspect | this
	 * 
	 * @post | result == toArray().length
	 */
	public int length() { return contents.length; }
	
	/**
	 * @inspect | this
	 * 
	 * @pre | 0 <= index && index < length()
	 * @post | result == toArray()[index]
	 */
	public char charAt(int index) { return contents[index]; }
	
	/**
	 * @pre contents != null
	 * 
	 * @post | Arrays.equals(toArray(), contents)
	 * 
	 * Alternative postcondities:
	 * @post | this.length() == contents.length
	 * @post | IntStream.range(0, contents.length).allMatch(i -> this.charAt(i) == contents[i])
	 */
	public String(char[] contents) { 
		//this.contents = contents; // FOUT! REPRESENTATION EXPOSURE!
		this.contents = contents.clone();
	}
}
