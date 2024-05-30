
class Interval {
//	int lowerBound;
//	int upperBound;
	
	
	private int lowerBound;
	private int upperBound;
	
	
//	int width;
	
	
//	int getLowerBound(Interval interval) {
//		return interval.lowerBound;
//	}
//
//	int getUpperBound(Interval interval) {
//		return interval.lowerBound + interval.width;
//	}
//
//	int getWidth(Interval interval) {
//		return interval.width;
//	}
//
//	void setLowerBound(Interval interval, int value) {
//		interval.lowerBound = value;
//	}
//
//	void setUpperBound(Interval interval, int value) {
//		interval.width = value - interval.lowerBound;
//	}
//
//	void setWidth(Interval interval, int value) {
//		interval.width = value;
//	}
	
	
//	int getLowerBound(Interval interval) {
//		return interval.lowerBound;
//	}
//		
//	int getUpperBound(Interval interval) {
//		return interval.upperBound;
//	}
//		
//	int getWidth(Interval interval) {
//		return interval.upperBound - interval.lowerBound;
//	}
//		
//	void setLowerBound(Interval interval, int value) {
//		interval.lowerBound = value;
//	}
//		
//	void setUpperBound(Interval interval, int value) {
//		interval.upperBound = value;
//	}
//		
//	void setWidth(Interval interval, int value) {
//		interval.upperBound = interval.lowerBound + value;
//	}
	
	
//	static int getLowerBound(Interval interval) {
//		return interval.lowerBound;
//	}
//
//	static int getUpperBound(Interval interval) {
//		return interval.upperBound;
//	}
//	
//	static int getWidth(Interval interval) {
//		return interval.upperBound - interval.lowerBound;
//	}
//
//	static void setLowerBound(Interval interval, int value) {
//		interval.lowerBound = value;
//	}
//
//	static void setUpperBound(Interval interval, int value) {
//		interval.upperBound = value;
//	}
//	
//	static void setWidth(Interval interval, int value) {
//		interval.upperBound = interval.lowerBound + value;
//	}
	
	
//	int getLowerBound() {
//		return this.lowerBound;
//	}
//
//	int getUpperBound() {
//		return this.upperBound;
//	}
//	
//	int getWidth() {
//		return this.upperBound - this.lowerBound;
//	}
//
//	void setLowerBound(int value) {
//		this.lowerBound = value;
//	}
//
//	void setUpperBound(int value) {
//		this.upperBound = value;
//	}
//	
//	void setWidth(int value) {
//		this.upperBound = this.lowerBound + value;
//	}
	
	
	int getLowerBound() {
		return lowerBound;
	}

	int getUpperBound() {
		return upperBound;
	}
	
	int getWidth() {
		return upperBound - lowerBound;
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
}
