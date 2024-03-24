package Colors;

public class Color {
	
	public final int red;
	public final int green;
	public final int blue;
	
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getHue() { throw new RuntimeException("Not yet implemented"); }
	public int getSaturation() { throw new RuntimeException("Not yet implemented"); }
	public int getValue() { throw new RuntimeException("Not yet implemented"); }
	
	public boolean equals(Object other) {
		return other.getClass() == this.getClass() && red == ((Color)other).red && green == ((Color)other).green && blue == ((Color)other).blue;
	}

}