
public class BusinessLogic {
	
	private Log log;
	
	public BusinessLogic(Log log) {
		this.log = log;
	}
	
	public void handleRequest(Request req) { 
		log.logMessage("Started handeling request: '" + req.toString() + "'.");
		//...
		log.logMessage("Handeling request step 2...");
		//...
		log.logMessage("Finished handeling request: '" + req.getId() + "'.");
	}
	
}
