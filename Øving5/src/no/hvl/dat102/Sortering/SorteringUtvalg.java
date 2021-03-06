package no.hvl.dat102.Sortering;

import java.util.Random;

public class SorteringUtvalg {

	public static void main(String[] args) {
		
		// Til bruk ved sortering av store tabellar
		 Random tilfeldig = new Random();
		 int n = 64000;
		 int antal = 10;
		 Integer[][] a = new Integer[antal][n];
		 // set inn tilfeldige heiltal i alle rekker
		 for (int i = 0; i < antal; i++){
		 for (int j = 0; j < n; j++){
		 a[i][j] = tilfeldig.nextInt();
		}
		 }
		 // sorter kvar rekke
		 // start tidsmåling
		 
		 long startTid = System.nanoTime();
		 for (int i = 0; i < antal; i++){
		 sorteringUtvalg(a[i]); // blir ein eindimensjonal tabell
		 }
		 long sluttid = System.nanoTime(); 
		 
		 double total = (sluttid - startTid)/10.0;
		 System.out.println("Gjennomsnittstid: " + total/1000000.0 + "ms");
		 
		// slutt tidsmåling
	}
	
	public static <T extends Comparable<T>> void sorteringUtvalg(T[] data) {
		int min; 
		T temp; 
		
		for(int i = 0; i<data.length; i++) {
			min = i; 
			for(int scan = i+1; scan<data.length; scan++) 
				if(data[scan].compareTo(data[min])<0)
					min=scan;
				
					swap(data, min, i); 
			
		}
	}
	
	private static <T extends Comparable<T>> void swap(T[] data, int i1, int i2) {
		
		T temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp; 
		
	}
}
