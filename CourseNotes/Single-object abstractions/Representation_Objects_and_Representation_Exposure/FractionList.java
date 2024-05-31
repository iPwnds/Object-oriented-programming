package Representation_Objects_and_Representation_Exposure;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import Managing_Complexity_through_Modularity_and_Abstraction.Fraction;

/**
 * Each instance of this class stores a list of fractions.
 */
public class FractionList {

    /**
     * @invar | elements != null
     * @invar | Arrays.stream(elements).allMatch(element -> element != null)
     *
     * @representationObject
     */
    private Fraction[] elements;

    /**
     * Returns the number of elements in the list of fractions stored by this
     * object.
     *
     * @post | 0 <= result
     */
    public int getSize() {
        return elements.length;
    }

    /**
     * Returns the element at the given index in the list of fractions stored by
     * this object.
     *
     * @throws IndexOutOfBoundsException | index < 0 || getSize() <= index
     */
    public Fraction getElementAt(int index) {
        if (index < 0 || getSize() <= index)
            throw new IndexOutOfBoundsException();

        return elements[index];
    }

    /**
     * Returns the sum of the elements of the list of fractions stored by this
     * object.
     *
     * @post | Objects.equals(result,
     *       |     IntStream.range(0, getSize())
     *       |         .mapToObj(i -> getElementAt(i))
     *       |         .reduce(Fraction.ZERO, (x, y) -> x.plus(y)))
     */
    public Fraction getSum() {
        return Arrays.stream(elements).reduce(Fraction.ZERO, (x, y) -> x.plus(y));
    }

    /**
     * Initializes this object to store an empty list of fractions.
     *
     * @post | getSize() == 0
     */
    public FractionList() {
        elements = new Fraction[0];
    }

    /**
     * Adds the given element to the end of the list of fractions stored by this
     * object.
     *
     * @throws NullPointerException | element == null
     * @mutates | this
     * @post | getSize() == old(getSize()) + 1
     * @post | Arrays.equals(
     *       |     IntStream.range(0, old(getSize()))
     *       |         .mapToObj(i -> getElementAt(i)).toArray(),
     *       |     old(IntStream.range(0, getSize())
     *       |         .mapToObj(i -> getElementAt(i)).toArray()))
     * @post | Objects.equals(getElementAt(old(getSize())), element)
     */
    public void add(Fraction element) {
        if (element == null)
            throw new IllegalArgumentException("element is null");

        Fraction[] newElements = new Fraction[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = element;
        elements = newElements;
    }

    public Fraction[] getElements() {
//        return elements; // WRONG! Leaks representation object.
        
        return elements.clone();
    }

}
