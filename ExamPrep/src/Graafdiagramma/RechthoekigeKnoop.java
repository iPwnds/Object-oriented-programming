package Graafdiagramma;

public class RechthoekigeKnoop extends Knoop {

	int breedte;
	int hoogte;
	
	public int getBreedte() {
		return breedte;
	}
	
	public int getHoogte() {
		return hoogte;
	}
	
	public RechthoekigeKnoop(int breedte, int hoogte) {
		if (breedte <= 0 || hoogte <= 0)
			throw new IllegalArgumentException("`straal` is not greater than zero");
		this.breedte = breedte;
		this.hoogte = hoogte;
	}
	
	public void berekenInfo(int[] info) {
		if (info.length < 2)
			throw new IllegalArgumentException("`info.length` is less than 2");
		info[0] = breedte * 2 + hoogte * 2;
		info[1] = breedte * hoogte;
	}
	
	
	public boolean isIsomorfMet(Knoop andere) {
		return andere instanceof RechthoekigeKnoop k && breedte == k.breedte && hoogte == k.hoogte;
	}
	
}
