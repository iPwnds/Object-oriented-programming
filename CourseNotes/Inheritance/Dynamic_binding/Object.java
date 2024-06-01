package Dynamic_binding;

public class Object {

    /**
     * Returns the Class object for this object's class.
     */
//    public Class getClass() { /* ... */ }

    /**
     * Returns a number suitable for use as a hash code when using this object as
     * a key in a hash table.
     *
     * Note: two objects that are equal according to the `equals(Object)` method
     * must have the same hash code.
     *
     * The implementation of this method in class java.lang.Object returns a hash
     * code based on the identity of this object. That is, this implementation
     * usually returns a different number for different objects, although this is
     * not guaranteed.
     */
//    public int hashCode() { /* ... */ }

    /**
     * Returns a textual representation of this object.
     *
     * The implementation of this method in class java.lang.Object is based on the
     * name of this object's class and this object's identity-based hash code.
     */
    public String toString() {
        return this.getClass().getName() + "@"
            + Integer.toHexString(this.hashCode());
    }

    /**
     * Returns whether this object is conceptually equal to the given object.
     *
     * The implementation of this method in class java.lang.Object returns whether
     * this object and the given object are the same object.
     */
    public boolean equals(Object other) { return other == this; }

    // ...

}
