package Colors;

public class TransparentColor extends Color {
	
	public final int transparency;
	
	public TransparentColor(int red, int green, int blue, int transparency) {
		super(red, green, blue);
		this.transparency = transparency;
	}
	
	public boolean equals(Object other) {
		return super.equals(other) && transparency == ((TransparentColor)other).transparency;
	}

}