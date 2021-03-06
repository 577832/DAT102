package no.hvl.dat102.Sortering;

import java.util.Random;

public class Boblesortering {

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
			bubbleSort(a[i]); // blir ein eindimensjonal tabell
		}
		long sluttid = System.nanoTime();

		double total = (sluttid - startTid) / 10.0;
		System.out.print( total / 1000000.0 + "ms");

		// slutt tidsm�ling
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] data) {

		int position, scan;
		T temp;

		for (position = data.length - 1; position >= 0; position--) {
			for (scan = 0; scan <= position - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) > 0)
					swap(data, scan, scan + 1);

			}
		}
	}

	private static <T extends Comparable<T>> void swap(T[] data, int i1, int i2) {

		T temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;

	}
}
