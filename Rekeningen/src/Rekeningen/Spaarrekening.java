package Rekeningen;

/**
 * @invar | 0 <= getBalans()
 */
public class Spaarrekening extends Rekening {

	/**
	 * @post | getBalans() == 0
	 */
	public Spaarrekening() {}
	
	/**
	 * @pre | 0 <= bedrag
	 * @mutates | this
	 * @post | getBalans() == old(getBalans())
	 * @post | result == 0
	 */
	@Override
	public int neemAf(int bedrag) {
		return 0;
	}
	
	/**
	 * @inspects | this
	 * @post | result != null
	 */
	@Override
	public String toString() {
		return "Spaarrekening[balans=" + getBalans() + "]";
	}
	
	/**
	 * @pre | andere != null
	 * @inspects | this, andere
	 * @post | result == (andere instanceof Spaarrekening && getBalans() == ((Spaarrekening)andere).getBalans())
	 */
	@Override
	public boolean isInDezelfdeToestandAls(Rekening andere) {
		return andere instanceof Spaarrekening && getBalans() == ((Spaarrekening)andere).getBalans();
	}

}