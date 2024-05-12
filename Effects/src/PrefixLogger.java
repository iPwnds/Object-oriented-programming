
public abstract class PrefixLogger extends Log {

	private Log log;
	private String prefix;
	
	public PrefixLogger(Log log, String prefix) {
		this.log = log;
		this.prefix = prefix;
	}
	
	@Override
	public void logMessage(String s) {
		log.logMessage(prefix + s);
	}

}
