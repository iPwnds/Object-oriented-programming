import java.util.ArrayList;

public class StubLogger extends Log {

	private ArrayList<String> buffer = new ArrayList<>();
	private ArrayList<Integer> inputs;
	
	public StubLogger(ArrayList<Integer> inputs) {
		this.inputs = inputs;
	}
	
	@Override
	public void logMessage(String s) {
		buffer.add(s);
	}

	public ArrayList<String> getBuffer() {
		return new ArrayList<>(buffer);
	}
	
	public int getInput() {
//		
//		// .size() is not working
//		
//		int inputs = inputs.get(inputs.size() - 1);
//		inputs.remove(inputs.size() - 1);
		return 0; //inputs
	}
	
}
