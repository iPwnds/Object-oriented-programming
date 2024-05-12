
public class DatabaseAccess {
	void modifyUserRecord(int entryId, User newData) {
		Log.logMessage("Started modifying user record in database: '" + entryId +
				"', '" + newData.toString() + "'.");
		Log.logMessage("Finished modifying user record in database: '" + entryId + "'.");
	}
}
