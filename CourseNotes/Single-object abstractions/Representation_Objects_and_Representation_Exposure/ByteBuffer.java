package Representation_Objects_and_Representation_Exposure;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a sequence of bytes and an offset into that
 * sequence.
 */
public class ByteBuffer {

    /**
     * @invar | bytes != null
     * @invar | 0 <= offset
     */
    private byte[] bytes;
    private int offset;

    /**
     * Returns an array containing the sequence of bytes stored by this object.
     *
     * @post | result != null
     */
    public byte[] getBytes() { return bytes; }

    /**
     * Returns the offset stored by this object.
     *
     * @post | 0 <= result
     */
    public int getOffset() { return offset; }

    /**
     * Initializes this object so that it stores the given sequence of bytes and
     * offset zero.
     *
     * @throws IllegalArgumentException if the given array is null
     *    | bytes == null
     * @post | Arrays.equals(getBytes(), bytes)
     * @post | getOffset() == 0
     */
    public ByteBuffer(byte[] bytes) {
        if (bytes == null)
            throw new IllegalArgumentException("bytes is null");
        this.bytes = bytes;
    }

    /**
     * Writes the given byte into the sequence of bytes stored by this object
     * at the current offset, and increments the offset.
     *
     * @throws ArrayIndexOutOfBoundsException if the current offset is outside
     *         the bounds of the sequence of bytes stored by this object.
     *    | getBytes().length <= getOffset()
     * @mutates | this // WRONG!
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
