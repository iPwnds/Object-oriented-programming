package ObjectenEnVelden;

import java.util.HashMap;
import java.util.Map;

public class JavaObject extends Waarde {

	HashMap<String, Veld> velden = new HashMap<>();
	HashMap<String, Veld> verwijzendeVelden = new HashMap<>();
	
	public Map<String, Veld> getVelden() {
		return Map.copyOf(velden);
	}

	public Map<String, Veld> getVerwijzendeVelden() {
		return Map.copyOf(verwijzendeVelden);
	}

	JavaObject() {
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj;
	}
	
}
