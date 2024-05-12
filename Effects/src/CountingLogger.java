
public abstract class CountingLogger extends Log {

	private Log log;
	
	public CountingLogger(Log log) {
		this.log = log;
	}
	
	int count = 0;
	
	@Override
	public void logMessage(String s) {		
		log.logMessage((count++) + ": " + s);
	}

}
