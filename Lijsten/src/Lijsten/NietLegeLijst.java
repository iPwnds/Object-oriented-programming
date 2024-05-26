package Lijsten;

public class NietLegeLijst extends Lijst {

	private int kop;
	private Lijst staart;
	
	public int getKop() { return kop; }
	public Lijst getStaart() { return staart; }
	
	public NietLegeLijst(int kop, Lijst staart) {
		this.kop = kop;
		this.staart = staart;
	}
	
	@Override
	public int getLength() {
		return 1 + staart.getLength();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NietLegeLijst nll &&
				kop == nll.kop &&
				staart.equals(nll.staart);
	}
	
	@Override
	public String toString() {
		return "[" + kop +
				(staart instanceof LegeLijst ? "]" :
					", " + staart.toString().substring(1));
	}
	
}