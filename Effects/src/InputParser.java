
public class InputParser {
	
	private Log log;
	
	public InputParser(Log log) {
		this.log = log;
	}
	
	Request parserInput(String userInput) {
		Request result = new Request(0);
		log.logMessage("Finished parsing: input was '" + userInput +
						"', parsed request is '" + result.toString() + "'.");
		return result;
	}
	
}
