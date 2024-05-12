
public class DatabaseAccess {
	
	private Log log;
	
	public DatabaseAccess(Log log) {
		this.log = log;
	}
	
	void modifyUserRecord(int entryId, User newData) {
		log.logMessage("Started modifying user record in database: '" + entryId +
				"', '" + newData.toString() + "'.");
		log.logMessage("Finished modifying user record in database: '" + entryId + "'.");
	}
	
}
