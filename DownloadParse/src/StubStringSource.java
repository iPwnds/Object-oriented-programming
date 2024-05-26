
public class StubStringSource implements StringSource {
	private String text;
	
	public StubStringSource(String text) {
		this.text = text;
	}
	
	@Override
	public String GetString() {
		return text;
	}

}
