package timeofday;

// 1. Abstractie definiëren = API definiëren =
//    hoe de klant de abstractie zal gebruiken
//
//    1.1. Rauwe abstractetoestandsruimte definiëren
//         = de getters declareren
//    1.2. Geldige abstractetoestandsruimte definiëren
//         = de abstractetoestandsinvarianten noteren
//    1.3. Constructoren en mutatoren declareren
//         en documenteren
//
// 2. Abstractie implementeren
//
//    2.1. Rauwe concretetoestandsruimte definiëren
//         = de velden definiëren
//    2.2. Geldige concretetoestandsruimte definiëren
//         = de representatie-invarianten noteren
//    2.3. Afbeelding concrete toestanden op abstracte toestanden definiëren
//         = de getters implementeren
//    2.4. De constructoren en mutatoren implementeren

/**
 * Each instance of this class stores a time of day.
 * 
 * @invar | 0 <= getHours() && getHours() <= 23
 * @invar | 0 <= getMinutes() && getMinutes() <= 59
 */
public class TimeOfDay {
	
	/**
	 * @invar | 0 <= minutesSinceMidnight
	 * @invar | minutesSinceMidnight < 24 * 60
	 */
	private int minutesSinceMidnight;

	public int getHours() { return minutesSinceMidnight / 60; }
	public int getMinutes() { return minutesSinceMidnight % 60; }
	
	/**
	 * @throws IllegalArgumentException | !(0 <= hours && hours <= 23)
	 * @throws IllegalArgumentException | !(0 <= minutes && minutes <= 59)
	 * 
	 * @post | getHours() == hours
	 * @post | getMinutes() == minutes
	 */
	public TimeOfDay(int hours, int minutes) {
		if (hours < 0 || 23 < hours)
			throw new IllegalArgumentException("`hours` out of range");
		if (minutes < 0 || 59 < minutes)
			throw new IllegalArgumentException("`minutes` out of range");
		this.minutesSinceMidnight = hours * 60 + minutes;
	}
	
	/**
	 * @pre | 0 <= hours && hours <= 23
	 * @mutates | this
	 * @post | getHours() == hours
	 * @post | getMinutes() == old(getMinutes())
	 */
	public void setHours(int hours) {
		minutesSinceMidnight = hours * 60 + minutesSinceMidnight % 60;
	}
	
	/**
	 * @pre | 0 <= minutes && minutes <= 59
	 * @mutates | this
	 * @post | getHours() == old(getHours())
	 * @post | getMinutes() == minutes
	 */
	public void setMinutes(int minutes) {
		minutesSinceMidnight = 60 * (minutesSinceMidnight / 60) + minutes;
	}
	
}