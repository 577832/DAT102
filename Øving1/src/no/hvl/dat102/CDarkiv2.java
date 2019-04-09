package no.hvl.dat102;

import ADT.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

	private int antall; 
	private LinearNode<CD> start; 
	
	public CDarkiv2() {
		start = null; 
		antall = 0; 
	}
	@Override
	public CD[] hentCdTabell() {
		
		CD[] tab = new CD[antall]; 
		
		LinearNode<CD> denne = start;
		
		
		for(int i = 0; i<antall; i++) {
			tab[i] = denne.getElement();
			denne = denne.getNeste(); 
		}
		
		
		return tab;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd); 
		
		nyNode.setNeste(start);
		start = nyNode; 
		antall++; 
		
	}

	@Override
	public boolean slettCd(int cdNr) {
		
		boolean slettet = false; 
		LinearNode<CD> forrige = null; 
		LinearNode<CD> denne = start; 
		
		if(denne != null && cdNr == denne.getElement().getCdNummer() ) {
			start = denne.getNeste();
			antall--;
			slettet = true; 
		}else if(antall>1){
			while(denne != null && denne.getElement().getCdNummer() != cdNr) {
				forrige = denne; 
				denne = denne.getNeste(); 
			}
			forrige.setNeste(denne.getNeste());
			antall--;
			slettet = true; 
		}
		
		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		
		LinearNode<CD> denne = start; 
		CD[] delstrengtab = new CD[antall]; 
		int j = 0; 
		for(int i = 0; i<antall; i++) {
			if(denne.getElement().getTittel().contains(delstreng)) {
				delstrengtab[i] = denne.getElement(); 
				denne = denne.getNeste(); 
				j++;
			}
		}
		
		return trimTab(delstrengtab, j);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		
		
		LinearNode<CD> denne = start; 
		CD[] delstrengtab = new CD[antall]; 
		
		int j = 0; 
		for(int i = 0; i<antall; i++) {
			if(denne.getElement().getArtist().contains(delstreng)) {
				delstrengtab[i] = denne.getElement(); 
				denne = denne.getNeste(); 
				j++;
			}
		}
		
		return trimTab(delstrengtab, j);
		
	}

	//Hjelpemetode
	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n]; 
		int k = 0; 
		int i = 0; 
		while(i<tab.length) {
			if(tab[i] != null) {
				cdtab2[k] = tab[i];
				k++;
			}
			i++;
		}
		
		
		return cdtab2;
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		LinearNode<CD> denne = start; 
		int antallSjanger = 0;

		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getSjanger() == sjanger) {
				denne = denne.getNeste(); 
				antallSjanger++;
			}
		}
		return antallSjanger;
		
	}

	@Override
	public int antall() {
		
		return antall;
	}

}
