package no.hvl.dat102;

import no.hvl.dat102.exception.EmptyCollectionException;

//********************************************************************
// KjedetBin�rS�keTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt bin�rt s�ketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et bin�rt s�ketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re trett er tomt og usann ellers.
	 *****************************************************************/
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re treet er tom og usann ellers.
	 *****************************************************************/
	public boolean erTom() {
		return (antall == 0);
	}

	/**********************************************************************
	 * Legger det spesifiserte elementet p� passende plass i BS-treet. Like
	 * elementer blir lagt til h�yre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		// TODO Blir skriven i forelesing
		return null;
	}

	/******************************************************************
	 * Legger det spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 ******************************************************************/

	public void leggTil2(T element) {
		// TODO Blir skriven i forelesing
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette bin�re s�ketreet.
	 *********************************************************************/
	public T fjernMin() {

		T resultat = null;

		if (erTom()) {
			throw new EmptyCollectionException("BSTre");
		} else {
			if (rot.getVenstre() == null) {
				resultat = rot.getElement();
				rot = rot.getHoyre();
			} else {
				BinaerTreNode<T> p = rot;
				BinaerTreNode<T> denne = rot.getVenstre();
				while (denne.getVenstre() != null) {
					p = denne;
					denne = denne.getVenstre();
				}
				resultat = denne.getElement();
				p = denne.getHoyre();
			}
			antall--;
		}
		return resultat;
	}

	/******************************************************************
	 * Fjerner noden med st�rste verdi fra dette bin�re s�ketreet.
	 ******************************************************************/
	public T fjernMaks() {
		// TODO Blir skriven i forelesing
		return null;
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	public T finnMin() {
		// TODO Blir skriven i forelesing
		return null;
	}//

	/******************************************************************
	 * Returnerer det st�rste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	public T finnMaks() {
		// TODO Blir skriven i forelesing
		return null;
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	public T finn(T element) {

		return finnNode(element, rot);
	}

	private T finnNode(T element, BinaerTreNode<T> p) {
		int sml = element.compareTo(p.getElement());
		T svar = null;

		if (sml == 0) {// basis funnet
			svar = p.getElement();
		} else if (sml < 0) {
			svar = finnNode(element, p.getVenstre());
		} else {
			svar = finnNode(element, p.getHoyre());
		}
		return svar;
	}
	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// TODO Blir skriven i forelesing
		return null;
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		} // else bass: gjer ingenting
	}
	
	
	public Comparable<T>[] sorterTab(){
		Comparable[] svar = new Comparable[antall]; 
		fyllInn(rot, new Posisjon(), svar);
		return svar;
	}
	private void fyllInn(BinaerTreNode<T> p, Posisjon posisjon, Comparable[] tab) {
		if( p != null) {
			fyllInn(p.getVenstre(), posisjon, tab);
			tab[posisjon.getPos()] = p.getElement();
			posisjon.neste();
			fyllInn(p.getHoyre(), posisjon, tab); 
		}//else basis, gj�r ingenting
	}
}// class
