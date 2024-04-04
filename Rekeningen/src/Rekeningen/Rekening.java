package Rekeningen;

public abstract class Rekening {
	
	private int balans;
	
	/**
	 * @basic
	 */
	public int getBalans() { return balans; }
	
	/**
	 * @post | getBalans() == 0
	 */
	protected Rekening() {}
	
	/**
	 * @mutates | this
	 * @post | getBalans() == nieuweBalans
	 */
	protected void setBalans(int nieuweBalans) {
		this.balans = nieuweBalans;
	}
	
	/**
	 * @pre | 0 <= bedrag
	 * @mutates | this
	 * @post | getBalans() == old(getBalans()) + bedrag
	 */
	public void stort(int bedrag) {
		balans += bedrag;
	}
	
	/**
	 * @pre | 0 <= bedrag
	 * @mutates | this
	 * @post | 0 <= result
	 * @post | result <= bedrag
	 * @post | getBalans() == old(getBalans()) - result
	 */
	public abstract int neemAf(int bedrag);
	
	/**
	 * @pre | andere != null
	 * @inspects | this, andere
	 */
	public abstract boolean isInDezelfdeToestandAls(Rekening andere);

}