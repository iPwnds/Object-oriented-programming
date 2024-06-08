package Implementation_inheritance;

import java.util.Objects;

public class TransparentColor extends Color {
    public final int transparency;
    public TransparentColor(int red, int green, int blue, int transparency) {
        super(red, green, blue);
        this.transparency = transparency;
    }
    @Override
    public String toString() {
        return
            "rgba(" + red + ", " + green + ", " + blue + ", " + transparency + ")";
    }
    @Override
    public boolean equals(Object other) {
        return
            super.equals(other) &&
            ((TransparentColor)other).transparency == transparency;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), transparency);
    }
}
