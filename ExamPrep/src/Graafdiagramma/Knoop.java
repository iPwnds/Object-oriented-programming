package Graafdiagramma;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public abstract class Knoop {

	Set<Boog> uitgaandeBogen = new HashSet<>();	
	Set<Boog> inkomendeBogen = new HashSet<>();
	
	public Set<Boog> getUitgaandeBogen() {
		return Set.copyOf(uitgaandeBogen);
	}
	
	public Set<Boog> getInkomendeBogen() {
		return Set.copyOf(inkomendeBogen);
	}
	
	Knoop() {
	}
	
	/**
	 * @pre | info.length == 2
	 * @mutates info
	 * 
	 * @param info
	 */
	public abstract void berekenInfo(int[] info);
	
	public abstract boolean isIsomorfMet(Knoop andere);
	
	public Iterator<Knoop> getVolgendeKnopenIterator() {
		return new Iterator<>() {
			Iterator<Boog> uitgaandeBogenIterator = uitgaandeBogen.iterator();
			@Override
			public boolean hasNext() {
				return uitgaandeBogenIterator.hasNext();
			}
			@Override
			public Knoop next() {
				return uitgaandeBogenIterator.next().getDoelKnoop();
			}
		};
	}
	
	public void forEachVolgendeKnoop(Consumer<? super Knoop> consumer) {
		for (Boog boog : uitgaandeBogen)
			if (boog.getDoelKnoop() != null)
				consumer.accept(boog.getDoelKnoop());
	}
	
	public Stream<Boog> getUitgaandeBogenVanVolgendeKnopenStream() {
		return uitgaandeBogen
				.stream()
				.map(b -> b.getDoelKnoop())
				.filter(k -> k != null)
				.flatMap(k -> k.uitgaandeBogen.stream());
	}
	
}
