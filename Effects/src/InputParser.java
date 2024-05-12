
public class InputParser {
	Request parserInput(String userInput) {
		Request result = new Request(0);
		Log.logMessage("Finished parsing: input was '" + userInput +
						"', parsed request is '" + result.toString() + "'.");
		return result;
	}
}
