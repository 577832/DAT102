package no.hvl.dat102.Sortering;

import java.util.Random;

public class QuickSort {

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
			quickSort(a[i]); // blir ein eindimensjonal tabell
		}
		long sluttid = System.nanoTime();

		double total = (sluttid - startTid) / 10.0;
		System.out.print(total / 1000000.0 + "ms");

		// slutt tidsm�ling
	}

	public static <T extends Comparable<T>> void quickSort(T[] data) {

		quickSort(data, 0, data.length - 1);

	}

	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
		if (min < max) {
			int indexPartition = partition(data, min, max);
			quickSort(data, min, indexPartition - 1);
			quickSort(data, indexPartition + 1, max);

		}
	}

	private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;

		partitionelement = data[middle];
		swap(data, middle, min);
		left = min;
		right = max;

		while (left < right) {
			while (left < right && data[left].compareTo(partitionelement) <= 0) {
				left++;
			}
			while (data[right].compareTo(partitionelement) > 0) {
				right--;
			}
			if (left < right) {
				swap(data, left, right);
			}

		}
		swap(data, min, right);
		return right;
	}

	private static <T extends Comparable<T>> void swap(T[] data, int i1, int i2) {

		T temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;

	}

}
