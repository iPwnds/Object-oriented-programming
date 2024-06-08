package SimpleCalculator;

public class Calculator {

	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int rem(int a, int b) {
		return a - b;
	}
	
	public static int mul(int a, int b) {
		return a * b;
	}
	
	public static int div(int a, int b) {
		return a / b;
	}
	
	public static int pow(int a, int b) {
		int i = b;
		while (i > 1) {
			a = a * a;
			i--;
		}
			
		return a;
	}
	
	public static double sqrt(int a) {
		int i = 0;
		while (i < 100) {
			int pow = i * i;
			if (pow == a) {
				return i;
			}
			i++;
		}
		return 0;
	}
	
}
