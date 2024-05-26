import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpStringSource implements StringSource {
	@Override
	public String GetString() {
		String s = null;
		URL website;
		InputStream stream;
		BufferedReader reader = null;
		try {
			website = new URL("https://people.cs.kuleuven.be/dominique.devriese/test.txt");
			stream = website.openStream();
			reader = new BufferedReader(new InputStreamReader(stream));
		
			s = reader.readLine();
			stream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( reader != null ) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return s;
	}
}
