
public abstract class SysErrLogger extends Log {
	
	@Override
	public void logMessage(String s) {
		System.err.println(s);
	}

}
