package Graafdiagramma;

public class CirkelvormigeKnoop extends Knoop {

	int straal;
	
	public int getStraal() {
		return straal;
	}

	public CirkelvormigeKnoop(int straal) {
		if (straal <= 0)
			throw new IllegalArgumentException("`straal` is not greater than zero");
		
		this.straal = straal;
		
	}

	public void berekenInfo(int[] info) {
		if (info.length < 2)
			throw new IllegalArgumentException("`info.length` is less than 2");
		
		info[0] = 2 * 314 * straal / 100;
		info[1] = 314 * straal * straal / 100;
	}
	
	public boolean isIsomorfMet(Knoop andere) {
		return andere instanceof CirkelvormigeKnoop k && straal == k.straal;
	}
	
}
