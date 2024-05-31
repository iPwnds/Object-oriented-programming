package Representation_Objects_and_Representation_Exposure;

import java.util.stream.IntStream;

/**
 * Each instance of this class stores a reference to a byte array and an offset
 * into that array.
 */
public class ByteBufferTransparent {

    /**
     * @invar | array != null
     * @invar | 0 <= offset
     */
    private byte[] array;
    private int offset;

    /**
     * Returns the array reference stored by this object.
     *
     * @post | result != null
     * @immutable This object is associated with the same array reference
     *            throughout its lifetime.
     */
    public byte[] getArray() { return array; }

    /**
     * Returns the offset stored by this object.
     *
     * @post | 0 <= result
     */
    public int getOffset() { return offset; }

    /**
     * Initializes this object to store the given array reference and offset zero.
     *
     * @throws IllegalArgumentException if the given array reference is null
     *    | array == null
     * @post | getArray() == array
     * @post | getOffset() == 0
     */
    public ByteBufferTransparent(byte[] array) {
        if (array == null)
            throw new IllegalArgumentException("array is null");
        this.array = array;
    }

    /**
     * Writes the given byte into the referenced array at the current offset, and
     * increments the offset.
     *
     * @throws ArrayIndexOutOfBoundsException if the current offset is outside
     *         the bound of the referenced array.
     *     | getArray().length <= getOffset()
     * @mutates | this, getArray()
     * @post | getOffset() == old(getOffset()) + 1
     * @post | getArray()[old(getOffset())] == b
     * @post The elements of the array referenced by this object, except for the
     *       element at the old offset, have remained unchanged.
     *    | IntStream.range(0, getArray().length).allMatch(i ->
     *    |     i == old(getOffset())
     *    |     || getArray()[i] == old(getArray().clone())[i])
     */
    public void put(byte b) {
        this.array[offset] = b;
        offset++;
    }

}
