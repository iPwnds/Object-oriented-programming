public class IOTest {
	StringSource ss;

	public IOTest() {
//		ss = new HttpStringSource();
		ss = new StubStringSource("Secret Number: 1234");
	}
	
	public IOTest(StringSource ss) {
		this.ss = ss;
	}
	
	public static void main(String[] args) {
		IOTest o = new IOTest();
		o.run();
	}

	public void run() {
		String s = ss.GetString();
		String[] words = s.split(" ");
		int secret = Integer.parseInt(words[2]);
		PrintResult(secret);
	}

	public void PrintResult(int secret) {
		System.out.println("The secret is:" + secret);
	}
}
