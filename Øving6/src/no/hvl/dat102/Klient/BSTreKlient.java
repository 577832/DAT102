package no.hvl.dat102.Klient;

import java.util.*;

import no.hvl.dat102.KjedetBSTre;

public class BSTreKlient {
	final static int ANTALL_NODER = 1024;
	final static int ANTALL_TRE = 100; 
	
	
	public static void main(String[] args) {
		int stoersteTre = 0; 
		int minsteTre = ANTALL_NODER; 
		int snitt = 0; 		
		
		Random tilfeldig = new Random();
		
		
		for(int i = 0; i< ANTALL_TRE; i++) {
			
			KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();
			for(int j = 0; j< ANTALL_NODER; j++) {
				Integer element  = new Integer(tilfeldig.nextInt(100));
				bs.leggTil(element);
			}
			
			int hoyde = bs.finnHoyde(); 
			snitt += hoyde; 
			if(stoersteTre < hoyde) {
				stoersteTre = hoyde; 
			}
			if(minsteTre > hoyde) {
				minsteTre = hoyde;
			}

		}
		
		System.out.println("Antall noder: " + ANTALL_NODER);
		System.out.println("Den minimale teoretiske h�yden: " + (Math.log(ANTALL_NODER)/Math.log(2)));
		System.out.println("Den maksimale teoretiske h�yde: "  + (ANTALL_NODER -1));
		System.out.println();
		
		snitt = snitt/ANTALL_TRE;
		System.out.println("H�yden til det laveste treet: " + minsteTre );
		System.out.println("H�yden til det h�yeste treet: " + stoersteTre);
		System.out.println("Gjennomsnittsh�yden til tr�rne: " + snitt);
	}
}