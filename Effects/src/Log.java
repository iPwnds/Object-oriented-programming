
public class Log {
	public static void logMessage(String s) {
		if(s.length() > 80) return;
		System.out.println(s);
	}
}
