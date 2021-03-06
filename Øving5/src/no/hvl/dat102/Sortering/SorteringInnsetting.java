package no.hvl.dat102.Sortering;

import java.util.Random;

public class SorteringInnsetting {

	public static void main(String[] args) {

		// Til bruk ved sortering av store tabellar
		Random tilfeldig = new Random();
		int n = 128000;
		int antal = 10;
		System.out.println("n: " + n);
		System.out.println("Antall m�linger: " + antal);
		System.out.print("M�lt i tid:  ");

		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt();
			}
		}
		// sorter kvar rekke
		// start tidsm�ling

		long startTid = System.nanoTime();
		for (int i = 0; i < antal; i++) {
			sorteringInnsetting(a[i]); // blir ein eindimensjonal tabell
		}
		long sluttid = System.nanoTime();

		double total = (sluttid - startTid) / 10.0;
		System.out.print("Gjennomsnittstid: " + total / 1000000.0 + "ms");

		// slutt tidsm�ling
	}
	
	
	
	public static <T extends Comparable<T>> void sorteringInnsetting(T[] data) {
		
		for(int i = 1; i<data.length; i++) {
			T key = data[i]; 
			int position= i; 
			
			while(position > 0 && data[position-1].compareTo(key)>0) {
			
				data[position] = data[position-1];
				position--; 
			}
			data[position] = key; 
		}
	}
}
