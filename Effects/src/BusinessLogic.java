import com.sun.net.httpserver.Request;

public class BusinessLogic {
	public void handleRequest(Request req) {
		Log.logMessage("Started handeling request: '" + req.toString() + "'.");
		//...
		Log.logMessage("Handeling request step 2...");
		//...
		Log.logMessage("Finished handeling request: '" + req.getId() + "'.");
	}
}
