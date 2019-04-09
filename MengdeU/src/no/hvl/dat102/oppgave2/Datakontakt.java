package no.hvl.dat102.oppgave2;

public class Datakontakt {

	private Medlem[] medlemstabell; 
	private int antallMedlemmer; 
	
	public Datakontakt() {
		
		medlemstabell = new Medlem[100];
		antallMedlemmer = 0;
	}
	public Datakontakt(int størrelse) {
		medlemstabell = new Medlem[størrelse];
		antallMedlemmer = 0; 
	}
	public void leggTilMedlem(Medlem person) {
			
			medlemstabell[antallMedlemmer] = person; 
			antallMedlemmer++; 
		}
		
	public int finnMedlemIndeks(String medlemsnavn) {
		
		int i = 0; 
		boolean funnet = false; 
		
		while(i<antallMedlemmer && !funnet) {
			if(medlemstabell[i].getNavn().toLowerCase().equals(medlemsnavn.toLowerCase())) {
				funnet = true; 
			}else {
				i++; 
			}
		}
		if(!funnet) {
			i = -1; 
		}
		return i; 
		
	}
	
	public int finnPartnerFor(String medlemsnavn) {
		int ind = finnMedlemIndeks(medlemsnavn);

		int indeks = 0;
		boolean funnet = false;
		int resultat = -1;

		if (medlemstabell[ind].getStatusIndeks() == -1) {
			while (indeks < antallMedlemmer && !funnet) {
				if (medlemstabell[indeks].passerTil(medlemstabell[ind]) && medlemstabell[indeks].getStatusIndeks() == -1
						&& indeks != ind) {
					funnet = true;
				} else {
					indeks++;
				}
			}
		}

		if (funnet) {
			medlemstabell[indeks].setStatusIndeks(ind);
			medlemstabell[ind].setStatusIndeks(indeks);
			resultat = indeks;
		}

		return resultat;
		
	}
	

	public void tilbakestillStatusIndeks(String medlemsnavn) {
		int m1 = finnMedlemIndeks(medlemsnavn);

		if (medlemstabell[m1].getStatusIndeks() != -1) {
			medlemstabell[medlemstabell[m1].getStatusIndeks()].setStatusIndeks(-1);
			medlemstabell[m1].setStatusIndeks(-1);
			System.out.println("Tilbakestilling vellykket.");

		} else {
			System.out.println(medlemstabell[m1].getNavn() + " har ikke partner.");
		}
	}
	
	public int antall() {
		return antallMedlemmer;
	}

	public Medlem[] getDatakontakt() {
		return medlemstabell;
	}
	
}
