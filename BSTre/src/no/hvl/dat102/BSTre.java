package no.hvl.dat102;

import no.hvl.dat102.exception.EmptyCollectionException;

public class BSTre<T extends Comparable<T>> implements BSTreADT<T> {

	private BinaerTreNode<T> rot;
	private int antall ;

	public BSTre() {
		rot = null;
		antall = 0; 
	}

	public BSTre(BinaerTreNode<T> r) {
		rot = r;
	}

	@Override
	public int antall() {
		
		return 0;
	}

	@Override
	public boolean erTom() {
		
		return antall() == 0;
	}

	@Override
	public void leggTil(T element) {
		// TODO Auto-generated method stub

	}

	@Override
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

	@Override
	public T finnMin() {

		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public T finnMaks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjernMin() {
		
		
		T resultat = null; 
		
		if(erTom()) {
			throw new EmptyCollectionException("BSTre"); 
		}else {
			if(rot.getVenstre() == null) {
				resultat = rot.getElement(); 
				rot = rot.getHoyre(); 
			}else {
				BinaerTreNode<T> p = rot; 
				BinaerTreNode<T> denne = rot.getVenstre();
				while(denne.getVenstre() != null){
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

	
	public void visInorden() {
		visInordenRek(rot); 
		System.out.println();
	}

	//VU f�r HU, pre, in, post
	private void visInordenRek(BinaerTreNode<T> p) {
		if(p!=null) {
			visInordenRek(p.getVenstre());
			System.out.println(p.getElement() + "");
			visInordenRek(p.getHoyre());
		}// else: basis gj�r ingenting
		
		
	}
	
	
	
	
	
	@Override
	public T fjernMaks() {
		// TODO Auto-generated method stub
		return null;
	}

}
