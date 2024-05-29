package IntervalPart2;

class Interval {
	private int lowerBound;
	private int upperBound;

	int getLowerBound() {
		return lowerBound;
	}
	
	int getUpperBound() {
		return upperBound;
	}

	int getWidth() {
		return upperBound - lowerBound;
	}

	Interval(int initialLowerBound, int initialUpperBound) {
		lowerBound = initialLowerBound;
		upperBound = initialUpperBound;
	}
	
	Interval(int lowerBound, int width, Void dummy) {
		this.lowerBound = lowerBound;
		this.upperBound = lowerBound + width;
	}

	void setLowerBound(int value) {
		lowerBound = value;
	}
	
	void setUpperBound(int value) {
		upperBound = value;
	}
	
	void setWidth(int value) {
		upperBound = lowerBound + value;
	}
	
	void setWidth(int value, boolean updateLowerBound) {
		if (updateLowerBound)
		lowerBound = upperBound - value;
		else
		upperBound = lowerBound + value;
	}
}