package Graafdiagramma;

public class Boog {

	Knoop bronKnoop;
	Knoop doelKnoop;
	
	int uitvalshoek;
	
	public Knoop getBronKnoop() {
		return bronKnoop;
	}
	
	public Knoop getDoelKnoop() {
		return doelKnoop;
	}
	
	public int getUitvalshoek() {
		return uitvalshoek;
	}
	
	/**
	 * @pre | uitvalshoek > 0 &&
	 * 		| uitvalshoek < 359
	 * @param uitvalshoek
	 * @return
	 */
	public Boog(int uitvalshoek) {
		this.uitvalshoek = uitvalshoek;
	}
	
	public void koppelBronKnoop(Knoop bronKnoop) {
		this.bronKnoop = bronKnoop;
		bronKnoop.uitgaandeBogen.add(this);
	}
	
	public void ontkoppelBronKnoop() {
		bronKnoop.uitgaandeBogen.remove(this);
		bronKnoop = null;
	}

	public void koppelDoelKnoop(Knoop doelKnoop) {
		this.doelKnoop = doelKnoop;
		doelKnoop.inkomendeBogen.add(this);
	}
	
	public void ontkoppelDoelKnoop() {
		doelKnoop.inkomendeBogen.remove(this);
		doelKnoop = null;
	}
	
}
