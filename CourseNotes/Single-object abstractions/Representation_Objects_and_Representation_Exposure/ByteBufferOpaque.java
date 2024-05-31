package Representation_Objects_and_Representation_Exposure;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a sequence of bytes and an offset into
 * that sequence.
 */
public class ByteBufferOpaque {

    /**
     * @invar | bytes != null
     * @invar | 0 <= offset
     *
     * @representationObject
     */
    private byte[] bytes;
    private int offset;

    /**
     * Returns a new array containing the sequence of bytes stored by this object.
     *
     * @creates | result
     * @post | result != null
     */
    public byte[] getBytes() { return bytes.clone(); }

    /**
     * Returns the offset stored by this object.
     *
     * @post | 0 <= result
     */
    public int getOffset() { return offset; }

    /**
     * Initializes this object so that it stores the given sequence of bytes
     * and offset zero.
     *
     * @throws NullPointerException if the given array is null
     *    | bytes == null
     * @inspects | bytes
     * @post | Arrays.equals(getBytes(), bytes)
     * @post | getOffset() == 0
     */
    public ByteBufferOpaque(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    /**
     * Writes the given byte into the sequence of bytes stored by this object
     * at the current offset, and increments the offset.
     *
     * @throws ArrayIndexOutOfBoundsException if the current offset is outside
     *         the bounds of the sequence of bytes stored by this object.
     *    | getBytes().length <= getOffset()
     * @mutates | this
     * @post | getOffset() == old(getOffset()) + 1
     * @post | getBytes().length == old(getBytes().length)
     * @post | getBytes()[old(getOffset())] == b
     * @post | IntStream.range(0, getBytes().length).allMatch(i ->
     *       |     i == old(getOffset()) || getBytes()[i] == old(getBytes())[i])
     */
    public void put(byte b) {
        this.bytes[offset] = b;
        offset++;
    }

}
