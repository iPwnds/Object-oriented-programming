package ObjectenEnVelden;

public class IntWaarde extends Waarde {

	private int waarde;
	
	public int getWaarde() {
		return waarde;
	}
	
	IntWaarde(int waarde) {
		this.waarde = waarde;
	}
	
	public boolean equals(Object obj) {
		return obj instanceof IntWaarde w && waarde == w.waarde;
	}

	public int hashCode() {
		return waarde;
	}

}