package How_to_properly_document_single_object_abstractions;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a list of text strings.
 */
public class StringList {

    /**
     * @invar | elements != null
     * @invar | Arrays.stream(elements).allMatch(e -> e != null)
     * @representationObject
     */
    private String[] elements;

    /**
     * @creates | result
     * @post The result is not {@code null}
     *    | result != null
     * @post The result's elements are not {@code null}
     *    | Arrays.stream(result).allMatch(e -> e != null)
     */
    public String[] getElements() {
        return elements.clone();
    }

    /**
     * Initializes this object so that it stores an empty list of text strings.
     *
     * @post This object's list of text strings is empty.
     *    | getElements().length == 0
     */
    public StringList() {
        elements = new String[0];
    }

    /**
     * Replaces each element of this object by the text string obtained by
     * replacing each character of the element by its corresponding uppercase
     * letter.
     *
     * @mutates | this
     * @post This object's number of elements equals its old number of elements.
     *    | getElements().length == old(getElements()).length
     * @post Each of this object's elements equals its old element at the same
     *       index after replacing each character by the corresponding
     *       uppercase letter.
     *    | IntStream.range(0, getElements().length).allMatch(i ->
     *    |     getElements()[i].equals(old(getElements())[i].toUpperCase()))
     */
    public void allToUpperCase() {
        for (int i = 0; i < elements.length; i++)
            elements[i] = elements[i].toUpperCase();
    }

    /**
     * Adds the given text strings to the end of this object's list of
     * text strings.
     *
     * @mutates | this
     * @inspects | other
     *
     * @throws IllegalArgumentException if argument {@code other} is 
     *         {@code null}
     *    | other == null
     * @throws IllegalArgumentException if any of the elements of the given array
     *         are {@code null}
     *    | Arrays.stream(other).anyMatch(e -> e == null)
     *
     * @post This object's number of elements equals its old number of
     *       elements plus the number of given text strings.
     *    | getElements().length == old(getElements()).length + other.length
     * @post This object's old elements have remained unchanged.
     *    | Arrays.equals(getElements(), 0, old(getElements()).length,
     *    |     old(getElements()), 0, old(getElements()).length)
     * @post The given list of text strings is a suffix of this object's list
     *       of text strings.
     *    | Arrays.equals(
     *    |     getElements(), old(getElements()).length, getElements().length,
     *    |     other, 0, other.length)
     */
    public void addAll(String[] other) {
        if (other == null)
            throw new IllegalArgumentException("other is null");
        for (int i = 0; i < other.length; i++)
            if (other[i] == null)
                throw new IllegalArgumentException("other[" + i + "] is null");

        String[] newElements = new String[elements.length + other.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        System.arraycopy(other, 0, newElements, elements.length, other.length);
        elements = newElements;
    }
}
