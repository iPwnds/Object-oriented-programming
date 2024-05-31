package How_to_properly_document_single_object_abstractions;

/**
 * Each instance of this class represents a time of day, at one-minute resolution.
 *
 * @immutable
 * @invar This object's hours are between 0 and 23
 *    | 0 <= getHours() && getHours() <= 23
 * @invar This object's minutes are between 0 and 59
 *    | 0 <= getMinutes() && getMinutes() <= 59
 */
public class TimeOfDay {

    /**
     * @invar | 0 <= hours && hours <= 23
     * @invar | 0 <= minutes && minutes <= 59
     */
    private final int hours;
    private final int minutes;

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }

    /**
     * Initializes this object with the given hours and minutes.
     * 
     * @throws IllegalArgumentException if the given hours are not between 0
     *         and 23
     *    | !(0 <= hours && hours <= 23)
     * @throws IllegalArgumentException if the given minutes are not between 0
     *         and 59
     *    | !(0 <= minutes && minutes <= 59)
     *
     * @post This object's hours equal the given hours
     *    | getHours() == hours
     * @post This object's minutes equal the given minutes
     *    | getMinutes() == minutes
     */
    public TimeOfDay(int hours, int minutes) {
        if (!(0 <= hours && hours <= 23))
            throw new IllegalArgumentException("hours out of range");
        if (!(0 <= minutes && minutes <= 59))
            throw new IllegalArgumentException("minutes out of range");
        this.hours = hours;
        this.minutes = minutes;
    }

    /**
     * Returns whether this time is before the given time.
     *
     * @pre Argument {@code other} is not {@code null}.
     *    | other != null
     * @post
     *      The result is {@code true} iff either this object's hours are less
     *      than the given object's hours, or this object's hours equal the
     *      given object's hours and this object's minutes are less than the
     *      given object's minutes.
     *    | result == (
     *    |     getHours() < other.getHours() ||
     *    |     getHours() == other.getHours() &&
     *    |         getMinutes() < other.getMinutes()
     *    | )
     */
    public boolean isBefore(TimeOfDay other) {
        return
            hours < other.hours ||
            hours == other.hours && minutes < other.minutes;
    }
}
