package no.hvl.dat102;

import java.lang.Integer.*; 
import java.util.Scanner;

import ADT.CDarkivADT;



public class Tekstgrensesnitt {


	// lese opplysningene om en CD fra tastatur
	 public CD lesCD() {
		 
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Nummer på CD");
		 int cdNummer = Integer.parseInt(scan.nextLine()); 
		 
		 System.out.println("Navn på artist");
		 String artist = scan.nextLine();
		 
		 System.out.println("Navn på tittel");
		 String tittel = scan.nextLine(); 
		 
		 System.out.println("År CD'en kom ut");
		 int year = Integer.parseInt(scan.nextLine()); 
		 
		 System.out.println("Sjanger på CD");
		 Sjanger sjanger = Sjanger.finnSjanger(Integer.parseInt((Meny.IN.nextLine())));
		 
		 System.out.println("Plateselskap");
		 String plateselskap = Meny.IN.nextLine(); 
		 
		 
		
		return new CD(cdNummer, artist, tittel, year, sjanger, plateselskap); 

		
		 
	 }
	 
	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	 public void visCD(CD cd) {
		 
		 System.out.println("CD-nummer: " + cd.getCdNummer() + "\n" +
				 "Artist: " + cd.getArtist() + "\n" + 
				 "Tittel: " + cd.getTittel() + "\n" + 
				 "Lanseringsår: " + cd.getYear() + "\n" +
				 "Sjanger: " + cd.getSjanger() + "\n" + 
				 "Plateselskap: " + cd.getPlateselskap()); 
	 }
	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	 public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng){
	
			CD[] tabell = cda.sokTittel(delstreng); 
			for(CD i : tabell) {
				visCD(i); 
			}
	 }
	// Skriver ut alle CD-er av en artist / en gruppe
	 public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		 
		 CD[] tabell = cda.sokArtist(delstreng); 
		 for(CD i : tabell) {
			 visCD(i); 
		 }
	 }
	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	 public void skrivUtStatistikk(CDarkivADT cda){
		System.out.println("Antall CD'er: " + cda.antall());
		 	
		
		 
		 for(Sjanger sj : Sjanger.values()) {
			 System.out.println(sj.name() + ": " + cda.antallSjanger(sj));
		 }
		 
	 }
	 public static void operasjoner() {
		 System.out.println("Skriv tallet for operasjonen du ønsker å utføre: " +"\n"
					+ "1: Legg inn en ny CD" +"\n"
					+ "2: Slette en CD" + "\n"
					+ "3: Hent tittel på CD med delstreng" + "\n"
					+ "4: Hente artister på CD med artistnavn" + "\n"
					+ "5: Hente antall CD'er" + "\n"
					+ "6: Skriv ut statistikk" + "\n"
					+ "0: Lagre og avslutt");
	 }
}
