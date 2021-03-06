package no.hvl.dat102.Sortering;

import java.util.Random;

public class Flettesortering {
	
	
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
			fletteSortering(a[i]); // blir ein eindimensjonal tabell
		}
		long sluttid = System.nanoTime();

		double total = (sluttid - startTid) / 10.0;
		System.out.print( total / 1000000.0 + "ms");

		// slutt tidsm�ling
	}

	public static <T extends Comparable<T>> void fletteSortering(T[] data) {
		
		fletteSortering(data, 0, data.length-1); 
		
	}
	
	private static <T extends Comparable<T>> void fletteSortering(T[] data, int min, int max) {
	
		if(min<max) {
			int mid = (min+max)/2; 
			fletteSortering(data, min, mid); 
			fletteSortering(data, mid+1, max); 
			flette(data, min, mid, max); 
		}
		
	}
	
	private static <T extends Comparable<T>> void flette(T[] data, int first, int mid, int last) {
		
		T[] temp = (T[])(new Comparable[data.length]);
		
		int first1 = first, last1 = mid; 
		int first2 = mid+1, last2 = last; 
		int index = first1; 
		
		
		while(first1 <= last1 && first2 <= last2) {
			if(data[first1].compareTo(data[first2]) < 0) {
				temp[index] = data[first1]; 
				first1++; 
			}
			else {
				temp[index] = data[first2]; 
				first2++; 
			}
			index++; 
		}
		while(first1 <= last1) {
			temp[index] = data[first1]; 
			first1++; 
			index++; 
		}
		
		while(first2 <= last2) {
			temp[index] = data[first2]; 
			first2++; 
			index++;
		}
		
		for(index = first; index<= last; index++) {
			data[index] = temp[index]; 
		}
	}
}
