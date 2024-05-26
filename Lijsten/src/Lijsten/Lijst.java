package Lijsten;

public abstract class Lijst {

	public abstract int getLength();
	
	public IntIterator iterator() {
		return new IntIterator() {
			Lijst lijst = Lijst.this;
			
			@Override
			public boolean hasNext() {
				return lijst instanceof NietLegeLijst;
			}
			
			@Override
			public int next() {
				NietLegeLijst nll = (NietLegeLijst)lijst;
				lijst = nll.getStaart();
				return nll.getKop();
			}
		};
	}
	
	public void forEach(IntConsumer consumer) {
		Lijst lijst = this;
		for (;;) {
			if (lijst instanceof NietLegeLijst nll) {
				consumer.accept(nll.getKop());
				lijst = nll.getStaart();
			} else
				break;
		}
	}
	
}