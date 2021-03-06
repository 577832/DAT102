package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.mengde.adt.*;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// S�ker etter og fjerner element.Retur med null ved ikke-funn

		boolean funnet = false;
		T svar = null;
		int i = 0;

		if (!erTom()) {
			while ((i < antall) && (funnet = false)) {
				if (element.equals(tab[i])) {
					svar = tab[i];
					funnet = true;
					tab[i] = tab[antall - 1];
					tab[antall - 1] = null;
					antall--;

				}
			}
		}

		return svar;
	}

	/*
	 * Lite effektiv!
	 * 
	 * @Override public MengdeADT<T> union(MengdeADT<T> m2) { TabellMengde<T> begge
	 * = new TabellMengde<T>(); for (int i = 0; i < antall; i++) {
	 * begge.leggTil(tab[i]); } Iterator<T> teller = m2.oppramser();
	 * 
	 * while (teller.hasNext()) { begge.leggTil(teller.next()); } return
	 * (MengdeADT<T>)begge; }
	 */
	@Override

	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();

		for (int i = 0; i < antall; i++) {
			((TabellMengde<T>) begge).settInn(tab[i]); // G�r igjennom this-mengden og legger alle elementene til i den
														// nye mengden begge,
														// om den ikke finnes fra f�r.
		}

		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			T element = teller.next(); // G�r igjennom m2 - mengden s� lenge det er elementer i mengden.
			if (!begge.inneholder(element)) {// settet inn elementet i mengden begge s� lenge det er en plass p� neste
												// plass..
				((TabellMengde<T>) begge).settInn(element);
			}
		}

		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element = null;
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			element = teller.next(); // Hvis elementet finnes i this mengden og i m2 mengden s� settes elementet inn
										// i den nye mengden snittM
			if (this.inneholder(element)) {
				((TabellMengde<T>) snittM).settInn(element);
			}
		}

		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;
		Iterator<T> teller = oppramser();

		while (teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}
		/* 
		 * Iterator<T> teller2 = m2.oppramser();
		while (teller2.hasNext()) {
			element = teller2.next();
			if (!this.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}
		*/
		return differensM;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element;
		Iterator<T> teller = m2.oppramser();

		if (antall == m2.antall()) {
			while (teller.hasNext() && likeMengder == true) { // teller.hasNext() sjekker at det er flere elementer og
																// sjekker om de er true.
				if (!inneholder(teller.next())) {
					likeMengder = false;
				}
			}
		} else {
			likeMengder = false;
		}
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		// Fyll ut
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}
	
	public String toString() {
		
		String resultat = ""; 
		
		for(int i = 0; i<antall; i++) {
			resultat += tab[i].toString() + "\t";
		}
		
		return resultat;
	}
	

}// class
