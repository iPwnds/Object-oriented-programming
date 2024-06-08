package Implementation_inheritance;

import java.util.Objects;

public class Color {
    public final int red, green, blue;
    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public void getHue() { /* ... */ }
    public void getSaturation() { /* ... */ }
    public void getValue() { /* ... */ }
    @Override
    public String toString() {
        return "rgb(" + red + ", " + green + ", " + blue + ")";
    }
    @Override
    public boolean equals(Object other) {
        return
            other.getClass() == getClass() &&
            ((Color)other).red == red &&
            ((Color)other).green == green &&
            ((Color)other).blue == blue;
    }
    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}
