package ObjectenEnVelden;

public class Veld {

	JavaObject object;
	
	private String naam;
	private Waarde waarde;
	
	public JavaObject getObject() { 
		return object; 
	}
	
	public String getNaam() {
		return naam;
	}
	
	public Waarde getWaarde() {
		return waarde;
	}
	
	Veld(JavaObject object, String naam, Waarde waarde) {
		this.object = object;
		this.naam = naam;
		this.waarde = waarde;
		
		object.velden.put(naam, this);
		
		if (waarde instanceof JavaObject o)
			o.verwijzendeVelden.add(this);
	}
	
	public void setWaarde(Waarde waarde) {
		if (this.waarde instanceof JavaObject o)
			o.verwijzendeVelden.remove(this);
		if (this.waarde instanceof JavaObject o)
			o.verwijzendeVelden.add(this);
	}

}
