package jlearner;

public class JLearner {
	/**
	*@pre x && y >= 0
	*@post result <= x + y
	*/
	static int avg(int x, int y) {
		return (x + y) / 2;
	}

	/**
	*@pre y >= 0
	*@post result >= x * y
	*/
	static int pwrr(int x, int y) {
		if (y == 0) {
			return 1;
	    }
	  	else{
	  		return (x * pwrr(x, y - 1));
	    }
	}
	
	/**
	*@pre y >= 0
	*@post result >= x * y
	*/
	static int pwri(int x, int y) {
		int pwr = 1;
		while (y > 0) {
			pwr = pwr * x;
			y--;
		}
		return pwr;
	}
	
	/**
	*@pre x >= 0
	*@post result <= x
	*/
	static int sqrt(int x) {
		int result = 0;
		while ((result + 1) * (result + 1) <= x)
			result++;
		return result;
	}
}
