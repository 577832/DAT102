package no.hvl.dat102.oppgave2;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Meny {

	public static final Scanner leser = new Scanner(System.in);
	
	public static void main(String[] args) {
		int input = 1;
		Datakontakt arkiv = new Datakontakt();
		
		while(input != 0) {
			Teksgrensesnitt.skrivUtMeny();
			
			input = parseInt(leser.nextLine());
			
			switch(input) {
			case 1: Medlem m = Teksgrensesnitt.lesMedlem();
					arkiv.leggTilMedlem(m);
					break;
			case 2: System.out.println("Skriv inn navn p� medlem:");
					String navn = leser.nextLine();
					int ind = arkiv.finnMedlemIndeks(navn);
					if (ind == -1) {
						System.out.println("Medlem ikke funnet");
					} else {
						Teksgrensesnitt.skrivHobbyListe(arkiv.getDatakontakt()[ind]);
					}
					break;
			case 3: Teksgrensesnitt.skrivParListe(arkiv);
					break;
			case 4: System.out.println("Skriv inn navn p� medlem:");
					navn = leser.nextLine();
					int res = arkiv.finnPartnerFor(navn);
					if (res == -1) {
						System.out.println("Fant ingen partnere for " + navn + ".");
					} else {
						System.out.println("Partner funnet for " + navn + ".");
					}
					break;
			case 5: System.out.println("Skriv inn navn p� medlem:");
					navn = leser.nextLine();
					arkiv.tilbakestillStatusIndeks(navn);
					break;
			case 6: System.out.println("Skriv navnet p� det f�rste medlemmet:");
					String navnM1 = leser.nextLine();
					System.out.println("Skriv navnet p� det andre medlemmet:");
					String navnM2 = leser.nextLine();
					int i1 = arkiv.finnMedlemIndeks(navnM1);
					int i2 = arkiv.finnMedlemIndeks(navnM2);
					System.out.println("Unionen:");
					System.out.println(arkiv.getDatakontakt()[i1].unionHobbyer(arkiv.getDatakontakt()[i2]).toString());
					break;
			case 7: System.out.println("Skriv navnet p� det f�rste medlemmet:");
					navnM1 = leser.nextLine();
					System.out.println("Skriv navnet p� det andre medlemmet:");
					navnM2 = leser.nextLine();
					i1 = arkiv.finnMedlemIndeks(navnM1);
					i2 = arkiv.finnMedlemIndeks(navnM2);
					System.out.println("Differensen:");
					System.out.println(arkiv.getDatakontakt()[i1].differensHobbyer(arkiv.getDatakontakt()[i2]).toString());
					break;
			case 8:	System.out.println("Skriv navnet p� det f�rste medlemmet:");
					navnM1 = leser.nextLine();
					System.out.println("Skriv navnet p� det andre medlemmet:");
					navnM2 = leser.nextLine();
					i1 = arkiv.finnMedlemIndeks(navnM1);
					i2 = arkiv.finnMedlemIndeks(navnM2);
					System.out.println("Snittet:");
					System.out.println(arkiv.getDatakontakt()[i1].snittHobbyer(arkiv.getDatakontakt()[i2]).toString());
					break;
			case 9: System.out.println("Skriv navnet p� det f�rste medlemmet:");
					navnM1 = leser.nextLine();
					System.out.println("Skriv navnet p� det andre medlemmet:");
					navnM2 = leser.nextLine();
					i1 = arkiv.finnMedlemIndeks(navnM1);
					i2 = arkiv.finnMedlemIndeks(navnM2);
					if (arkiv.getDatakontakt()[i1].undermengde(arkiv.getDatakontakt()[i2])) {
						System.out.println("Hobbyene til " + navnM2 + " er en undermengde av"
								+ " hobbyene til " + navnM1);
					} else {
						System.out.println("Hobbyene til " + navnM2 + " er ikke en undermengde av"
								+ " hobbyene til " + navnM1);
					}
					break;
			}
		}
		
		leser.close();
		System.out.println("Programmet er avsluttet.");
	}

}
