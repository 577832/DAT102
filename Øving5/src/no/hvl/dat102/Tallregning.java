package no.hvl.dat102;

public class Tallregning {

	public static void main(String[] args) {
		
		for(int i = 0; i <= 10; i++) {
			System.out.println("For " + i + ": " + beregn(i));
		}

	}
	
	public static int beregn(int t) {
		int resultat; 
		
		if(t==0) {
			resultat = 2; 
			
		}else if(t== 1) {
			resultat = 5; 
		}else {
			resultat = 5*beregn(t-1) - 6*beregn(t-2) +2; 
		}
		return resultat; 
	}

}
