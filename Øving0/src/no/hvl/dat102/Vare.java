package no.hvl.dat102;


import java.util.Scanner;

import static java.lang.Double.*;

public class Vare {

	private int varenummer;
	private String navn;
	private double pris;

	public Vare(int varenummer, String navn, double pris) {
		this.varenummer = varenummer;
		this.navn = navn;
		this.pris = pris;
	}

	public Vare() {
		this(0, "", 0.0);
	}

	public Vare(int varenr) {
		this(varenr, "", 0.0);

	}

	public int getVarenummer() {
		return varenummer;
	}

	public void getVarenummer(int varenummer) {
		this.varenummer = varenummer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public void lesVare(int varenummer) {

		this.varenummer = varenummer;

		Scanner scan = new Scanner(System.in); 
		System.out.println("Navn på vare:");
		navn = scan.nextLine(); 
		System.out.println("Pris på vare:");
		
		double prisen;

		do {
			prisen = parseDouble(scan.nextLine());
			if(prisen<0.0) {
				System.out.println("Negativt tall, prøv igjen");
			}
		} while (prisen < 0.0);

		pris = prisen;
		
	}

}
