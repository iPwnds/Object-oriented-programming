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
	
	/**
	*@pre list != null
	*@post count <= list.length
	*/
	static int count(int[] list) {
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == 0) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * @pre list != null
	 * @post result == -list
	 */
	static int[] negation(int[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = -list[i];
		}
		return list;
	}
	
	/**
	 * @pre list != null
	 * @post negationList == -list
	 */
	static int[] negationClone(int[] list) {
		int[] negationList = list;
		for (int i = 0; i < list.length; i++) {
			negationList[i] = -list[i];
		}
		return negationList;
	}
	
	
}
