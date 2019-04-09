package no.hvl.dat102;

import java.util.Scanner;

public class Oppgave1 {

	public static void main(String[] args) {
	
	
	Scanner scan = new Scanner(System.in); 
	System.out.println("Skriv inn tallet for n: ");
	int tall = scan.nextInt(); 
	scan.close();
	
	
	System.out.println("Tallet blir: " + sum(tall));
	
	}
	
	public static int sum(int num) {
		
		int resultat; 
		if(num == 1) {
			resultat = 1; 
		}else {
			resultat = num + sum(num-1); 
	
		}
		return resultat;
	}
}
