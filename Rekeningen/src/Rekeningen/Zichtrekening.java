package Rekeningen;

/**
 * @invar | 0 <= getKredietlimiet()
 * @invar | -getKredietlimiet() <= getBalans()
 */
public class Zichtrekening extends Rekening {
	
	/**
	 * @invar | 0 <= kredietlimiet
	 * @invar | -kredietlimiet <= getBalans()
	 */
	private int kredietlimiet;
	
	public int getKredietlimiet() { return kredietlimiet; }
	
	/**
	 * @pre | 0 <= kredietlimiet
	 * @post | getBalans() == 0
	 * @post | getKredietlimiet() == kredietlimiet
	 */
	public Zichtrekening(int kredietlimiet) {
		this.kredietlimiet = kredietlimiet;
	}
	
	/**
	 * @pre | 0 <= bedrag
	 * @mutates | this
	 * @post | getBalans() == old(getBalans()) - result
	 * @post | bedrag <= old(getBalans()) + getKredietlimiet() ?
	 *       |     result == bedrag
	 *       | :
	 *       |     result == old(getBalans()) + getKredietlimiet()
	 */
	@Override
	public int neemAf(int bedrag) {
		int oudeBalans = getBalans();
		if (bedrag > getBalans() + kredietlimiet)
			setBalans(-kredietlimiet);
		else
			setBalans(getBalans() - bedrag);
		return oudeBalans - getBalans();
	}
	
	/**
	 * @inspects | this
	 * @post | result != null
	 */
	@Override
	public String toString() {
		return "Zichtrekening[balans=" + getBalans() + ",kredietlimiet=" + getKredietlimiet() + "]";
	}

	/**
	 * @pre | andere != null
	 * @inspects | this, andere
	 * @post | result == (
	 *       |     andere instanceof Zichtrekening &&
	 *       |     getBalans() == ((Zichtrekening)andere).getBalans() &&
	 *       |     getKredietlimiet() == ((Zichtrekening)andere).getKredietlimiet()
	 *       | )
	 */
	@Override
	public boolean isInDezelfdeToestandAls(Rekening andere) {
		return andere instanceof Zichtrekening &&
				getBalans() == ((Zichtrekening)andere).getBalans() &&
				getKredietlimiet() == ((Zichtrekening)andere).getKredietlimiet();
	}
	
}