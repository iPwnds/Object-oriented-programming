package Lijsten;

public class LegeLijst extends Lijst {

	public LegeLijst() {}
	
	@Override
	public int getLength() {
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof LegeLijst;
	}
	
	@Override
	public String toString() {
		return "[]";
	}
	
}