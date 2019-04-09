package no.hvl.dat102.oppgave2;
import no.hvl.dat102.oppgave2.Medlem;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
public class KlientMedlem {

	public static void main(String[] args) {
		
		Hobby h1 = new Hobby("Fotball"); 
		Hobby h2 = new Hobby("Gaming");
		Hobby h3 = new Hobby("Lese");
		
		
		KjedetMengde<Hobby> m1 = new KjedetMengde<Hobby>();
		
		m1.leggTil(h1);
		m1.leggTil(h2);
		
		KjedetMengde<Hobby> m2 = new KjedetMengde<Hobby>(); 
		
		m2.leggTil(h1);
		m2.leggTil(h3);

		
		Medlem p1 = new Medlem("Christian Nor ", m1);
		Medlem p2 = new Medlem("Morten Tordag ", m2);
		
		p1.skrivUt();
		p2.skrivUt();
		
		
			
		
	}

}
