package no.hvl.dat102;

import ADT.CDarkivADT;

public class CDarkivKlient {

	public static void main(String[] args) {
		
	/*	CDarkivADT cda = new CDarkiv(10); 
		Meny meny = new Meny(cda); 
		meny.start();
	*/
		
		CDarkivADT cda = new CDarkiv2(); 
		Meny meny = new Meny(cda); 
		meny.start();
	}

}
