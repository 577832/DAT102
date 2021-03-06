package no.hvl.dat102;

public class SolveTowers {
	
	public static void main(String[] args) {
		
		T�rnHanoi towers = new T�rnHanoi(16);
		
		long nanoFirst = System.nanoTime(); 
		
		towers.solve(); 
		
		long nanosist = System.nanoTime();
		
		double nanoTotal = (double)(nanosist - nanoFirst)/1_000_000 ;
		
		System.out.println("Tid brukt: " + nanoTotal + " ms");

	}

}
