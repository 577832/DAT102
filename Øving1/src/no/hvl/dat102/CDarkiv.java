package no.hvl.dat102;

import ADT.CDarkivADT;

public class CDarkiv implements CDarkivADT {

	// Instansvariable
	private CD[] cdTabell;
	private int antall;
	private final int STDKAP = 100;

	public CDarkiv(int storrelse) {
		cdTabell = new CD[STDKAP];
	}

	@Override
	public CD[] hentCdTabell() {

		return cdTabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		cdTabell[antall] = nyCd;
		antall++;

	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean slettet = false;
		int i = 0;

		while (i < antall && !slettet) {
			if (cdTabell[i].getCdNummer() == cdNr) {
				cdTabell[i] = cdTabell[antall - 1];
				cdTabell[antall - 1] = null;
				antall--;
				slettet = true;
			}
			i++;
		}
		return slettet;

	}

	public CD[] sokTittel(String delstreng) {

		CD[] delstrengtab = new CD[antall];
		int j = 0;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getTittel().contains(delstreng)) {
				delstrengtab[i] = cdTabell[i];
				j++;
			}
		}

		return trimTab(delstrengtab, j);

	}

	public CD[] sokArtist(String delstreng) {

		CD[] delstrengtab = new CD[antall];
		int j = 0;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getArtist().contains(delstreng)) {
				delstrengtab[i] = cdTabell[i];
				j++;
			}
		}

		return trimTab(delstrengtab, j);
	}

	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int k = 0;
		int i = 0;
		while (i < tab.length) {
			if (tab[i] != null) {
				cdtab2[k] = tab[i];
				k++;
			}
			i++;
		}

		return cdtab2;
	}

	public int antallSjanger(Sjanger sjanger) {

		int antallSjanger = 0;

		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;

	}

	public int antall() {
		return antall;
	}

}
