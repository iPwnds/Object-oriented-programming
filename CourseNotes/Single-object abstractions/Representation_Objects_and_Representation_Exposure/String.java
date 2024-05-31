package Representation_Objects_and_Representation_Exposure;

import java.util.stream.IntStream;

/**
 * Each instance of this class represents a sequence of text characters.
 *
 * @immutable
 */
public class String {

    /**
     * @invar | characters != null
     *
     * @representationObject
     */
    private final char[] characters;

    private String(char[] characters) {
        this.characters = characters;
    }

    /**
     * Returns the length of the sequence of characters represented by this object.
     *
     * @post | 0 <= result
     */
    public int length() {
        return characters.length;
    }

    /**
     * Returns the character at the given index in the sequence of characters
     * represented by this object. The first character is at index 0.
     *
     * @throws IndexOutOfBoundsException if the given index is less than zero
     *         or not less than the length of this object.
     *    | index < 0 || length() <= index
     */
    public char charAt(int index) {
        if (index < 0 || length() <= index)
            throw new IndexOutOfBoundsException();
        return characters[index];
    }

    /**
     * Returns a `String` object of length 1 containing the single given character.
     *
     * @post | result != null
     * @post | result.length() == 1
     * @post | result.charAt(0) == c
     */
    public static String valueOf(char c) {
        return new String(new char[] {c});
    }

    /**
     * Returns a `String` object that represents the sequence of characters
     * obtained by concatenating the sequence of characters represented by this
     * object and the given object, respectively.
     *
     * @throws NullPointerException | other == null
     * @post | result != null
     * @post | result.length() == length() + other.length()
     * @post | IntStream.range(0, length()).allMatch(i ->
     *       |     result.charAt(i) == charAt(i))
     * @post | IntStream.range(0, other.length()).allMatch(i ->
     *       |     result.charAt(length() + i) == other.charAt(i))
     */
    public String concat(String other) {
        char[] cs = new char[characters.length + other.characters.length];
        System.arraycopy(characters, 0, cs, 0, characters.length);
        System.arraycopy(other.characters, 0, cs, characters.length,
            other.characters.length);
        return new String(cs);
    }
    
    /**
     * Returns an array containing the sequence of characters represented by this
     * object.
     *
     * @creates | result
     *
     * @post | result != null
     * @post | result.length == length()
     * @post | IntStream.range(0, length()).allMatch(i ->
     *       |     result[i] == charAt(i))
     */
    public char[] toCharArray() {
//        return characters;  // WRONG! Representation exposure
    	
    	
        return characters.clone();
    }
    
    /**
     * Returns a `String` object whose sequence of characters equals the
     * sequence of characters stored in the given array.
     *
     * @throws NullPointerException | characters == null
     * @inspects | characters
     * @post | result != null
     * @post | result.length() == characters.length
     * @post | IntStream.range(0, characters.length)
     *       |     .allMatch(i -> result.charAt(i) == characters[i])
     */
    public static String valueOf(char[] characters) {
//        return new String(characters); // WRONG! Client-supplied object
//                                       // used as representation object.
    	
    	
        return new String(characters.clone());
    }
}
