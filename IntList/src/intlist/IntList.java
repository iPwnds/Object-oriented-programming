package intlist;

import java.util.Arrays;

// Stappenplan definiëren API data-abstractie:
//
// 1. Rauwe abstractetoestandsruimte =
//    getters declareren (= naam en return type)
//
// 2. Geldige abstracte toestanden definiëren =
//    abstractetoestandsinvarianten noteren
//
// 3. Declareren en documenteren van constructoren en mutatoren

// Stappenplan implementeren data-abstractie:
//
// 1. Rauwe concretetoestandsruimte definiëren =
//    velden definiëren (+ @representationObject-tags)
//
// 2. Geldige concretetoestandsruimte definiëren =
//    representatie-invarianten noteren
//
// 3. Afbeelding concrete toestanden op abstracte toestanden definiëren =
//    implementeren getters
//
// 4. Implementeren van constructoren en mutatoren


public class IntList {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representObject 
	 */
	private int[] elements;
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public int[] getElements() { return elements.clone(); }
	
	/**
	 * @post | result == getElements().length
	 */
	public int getLength() { return elements.length; }
	
	/**
	 * @pre | 0 <= index && index < getLength()
	 * @inspects | this
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) { return elements[index]; }
	
	/**
	 * @post | getLength() == 0
	 */
	public IntList() {
		elements = new int[0];
	}
	
	/**
	 * @mutates | this
	 * @post | getLength() == old(getLength()) + 1
	 * @post | Arrays.equals(getElements(), 0, old(getLength()), old(getElements()), 0, old(getLength()))
	 * @post | getElements()[old(getLength())] == element
	 */
	public void add(int element) {
		elements = Arrays.copyOf(elements, elements.length + 1);
		elements[elements.length - 1] = element;
	}
	
	/**
	 * @pre | getLength() > 0
	 * @mutates | this
	 * @post | getLength() == old(getLength()) - 1
	 * @post | Arrays.equals(getElements(), 0, getLength(), old(getElements()), 0, getLength())
	 */
	public void removeLast() {
		elements = Arrays.copyOf(elements, elements.length - 1);
	}

}
