
public abstract class SysOutLogger extends Log {

	@Override
	public void logMessage(String s) {
		System.out.println(s);
	}

}
