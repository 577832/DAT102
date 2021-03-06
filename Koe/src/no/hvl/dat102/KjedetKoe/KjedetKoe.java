package no.hvl.dat102.KjedetKoe;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

public class KjedetKoe<T> implements KoeADT<T> {

	private int antall;
	private LinearNode<T> start, slutt;

	@Override
	public void innKoe(T element) {

		LinearNode<T> node = new LinearNode<T>(element);

		if (erTom()) {
			start = node;
		} else {
			slutt.setNeste(node);
			slutt = node;
			antall++;
		}
	}

	@Override
	public T utKoe() throws EmptyCollectionException {

		if (erTom()) {
			throw new EmptyCollectionException("Koe");
		}

		T resultat = start.getElement();
		start = start.getNeste();
		antall--;
		if (erTom())
			slutt = null;

		return resultat;

	}

	@Override
	public T foerste() {

		if (erTom()) {
			throw new EmptyCollectionException("Koe");
		}
		T resultat = start.getElement();
		return resultat;

	}

	@Override
	public boolean erTom() { 
		
		return antall == 0; 
	}

	@Override
	public int antall() {
	
		return antall;
	}

}
