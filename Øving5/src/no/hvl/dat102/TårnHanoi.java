package no.hvl.dat102;

import java.lang.*;

public class T�rnHanoi {

	private int totalDisks;
	private long i;

	
	public T�rnHanoi(int disks) {
		totalDisks = disks;
		i = 0;
		
	}

	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
		System.out.println("Antall flytt: " + i);
	}

	private void moveTower(int numDisks, int start, int end, int temp) {

		if (numDisks == 1) {
			moveOneDisk(start, end);

		} else {
			moveTower(numDisks - 1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks - 1, temp, end, start);
		}

	}	

	private void moveOneDisk(int start, int end) {
		i++;

	}

}