
public class Log {
	private static int count = 0;
	
	public static void logMessage(String s) {
		System.out.println("log message " + count + ": " + s);
		count++;
	}
}
