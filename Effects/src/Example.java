
public class Example {
	static int counter = 0;
	
	public static int computeSomething (int x, int y){
		return x + y;
	}
	
	public static int computeSomethingWithInternalEffect (int x, int y) {
		counter++;
		
		return x + y;
	}
	
	public static int ComputeSomethingWithExternalEffect (int x, int y) {
		System.out.println("log: dit of dat");
//		Network.sendMessage("1234");
		
		return x + y;
	}
}
